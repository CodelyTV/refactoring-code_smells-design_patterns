use std::fmt;

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
    use crate::tiered_pricing::{get_total_subscription_price, NumberSubscriptionsError};
    use fake::Fake;

    #[test]
    fn when_subscriptions_are_between_1_and_2_unit_price_is_299(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (1..=2).fake();

        assert_eq!(
            number_of_subscriptions * 299,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    fn when_subscriptions_are_between_3_and_10_unit_price_is_239(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (3..=10).fake();

        assert_eq!(
            number_of_subscriptions * 239,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    fn when_subscriptions_are_between_11_and_25_unit_price_is_219(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (11..=25).fake();

        assert_eq!(
            number_of_subscriptions * 219,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    fn when_subscriptions_are_between_26_and_50_unit_price_is_199(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (26..=50).fake();

        assert_eq!(
            number_of_subscriptions * 199,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    fn when_subscriptions_are_more_than_50_unit_price_is_149(
    ) -> Result<(), NumberSubscriptionsError> {
        let number_of_subscriptions = (51..1000).fake();

        assert_eq!(
            number_of_subscriptions * 149,
            get_total_subscription_price(number_of_subscriptions)?
        );

        Ok(())
    }

    #[test]
    fn when_get_0_subscriptions_return_error() {
        assert!(get_total_subscription_price(0).is_err());
    }
}
