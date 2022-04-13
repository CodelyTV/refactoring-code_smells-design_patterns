use actix_web::{web, HttpResponse, Responder};
use serde::{Deserialize, Serialize};
use std::fmt;

#[derive(Deserialize)]
pub struct TieredPricingQuery {
    subscriptions: u32,
}

#[derive(Serialize, Deserialize)]
struct TieredPricingResponse {
    total_price: u32,
}

#[derive(Serialize, Deserialize)]
struct BadRequestMessage {
    error_message: String,
}

pub async fn tiered_pricing(pricing: web::Query<TieredPricingQuery>) -> impl Responder {
    match get_total_subscription_price(pricing.subscriptions) {
        Ok(total_price) => HttpResponse::Ok().json(TieredPricingResponse { total_price }),
        Err(error) => HttpResponse::BadRequest().json(BadRequestMessage {
            error_message: error.to_string(),
        }),
    }
}

type SubscriptionResult<T> = Result<T, NumberSubscriptionsError>;

#[derive(Debug)]
struct NumberSubscriptionsError;

impl fmt::Display for NumberSubscriptionsError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "Subscriptions must be greater than 0")
    }
}

fn get_unit_price(number_of_subscriptions: u32) -> SubscriptionResult<u32> {
    const FIRST_UNIT_PRICE: u32 = 299;
    const SECOND_UNIT_PRICE: u32 = 239;
    const THIRD_UNIT_PRICE: u32 = 219;
    const FOURTH_UNIT_PRICE: u32 = 199;
    const FIFTH_UNIT_PRICE: u32 = 149;

    match number_of_subscriptions {
        0 => Err(NumberSubscriptionsError),
        1 | 2 => Ok(FIRST_UNIT_PRICE),
        3..=10 => Ok(SECOND_UNIT_PRICE),
        11..=25 => Ok(THIRD_UNIT_PRICE),
        26..=50 => Ok(FOURTH_UNIT_PRICE),
        _ => Ok(FIFTH_UNIT_PRICE),
    }
}

fn get_total_subscription_price(number_of_subscriptions: u32) -> SubscriptionResult<u32> {
    Ok(number_of_subscriptions * get_unit_price(number_of_subscriptions)?)
}

#[cfg(test)]
mod tests {
    use super::*;
    use actix_web::{test, web, App};
    use fake::Fake;

    #[test]
    async fn when_subscriptions_are_between_1_and_2_unit_price_is_299(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (1..=2).fake();

        assert_eq!(
            number_of_subscriptions * 299,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    async fn when_subscriptions_are_between_3_and_10_unit_price_is_239(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (3..=10).fake();

        assert_eq!(
            number_of_subscriptions * 239,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    async fn when_subscriptions_are_between_11_and_25_unit_price_is_219(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (11..=25).fake();

        assert_eq!(
            number_of_subscriptions * 219,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    async fn when_subscriptions_are_between_26_and_50_unit_price_is_199(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (26..=50).fake();

        assert_eq!(
            number_of_subscriptions * 199,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    async fn when_subscriptions_are_more_than_50_unit_price_is_149(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (51..1000).fake();

        assert_eq!(
            number_of_subscriptions * 149,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    async fn when_get_0_subscriptions_return_error() {
        assert!(get_total_subscription_price(0).is_err());
    }

    #[actix_web::test]
    async fn when_send_n_subscriptions_return_price() {
        let number_of_subscriptions: u32 = (51..1000).fake();

        let app =
            test::init_service(App::new().route("/pricing", web::get().to(tiered_pricing))).await;

        let request = test::TestRequest::get()
            .uri(format!("/pricing?subscriptions={}", number_of_subscriptions).as_str())
            .to_request();

        let response: TieredPricingResponse = test::call_and_read_body_json(&app, request).await;

        assert_eq!(number_of_subscriptions * 149, response.total_price);
    }

    #[actix_web::test]
    async fn when_send_0_subscriptions_return_bad_request() {
        let app =
            test::init_service(App::new().route("/pricing", web::get().to(tiered_pricing))).await;

        let request = test::TestRequest::get()
            .uri("/pricing?subscriptions=0")
            .to_request();

        let response = test::call_service(&app, request).await;

        assert!(response.status().is_client_error())
    }
}
