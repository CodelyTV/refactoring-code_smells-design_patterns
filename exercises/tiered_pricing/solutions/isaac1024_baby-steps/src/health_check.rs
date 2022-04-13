use actix_web::{HttpResponse, Responder};

pub async fn health_check() -> impl Responder {
    HttpResponse::Ok()
}

#[cfg(test)]
mod tests {
    use super::*;
    use actix_web::{test, web, App};

    #[actix_web::test]
    async fn health_check_return_ok() {
        let app =
            test::init_service(App::new().route("/health-check", web::get().to(health_check)))
                .await;

        let request = test::TestRequest::get().uri("/health-check").to_request();

        let response = test::call_service(&app, request).await;

        assert!(response.status().is_success());
    }
}
