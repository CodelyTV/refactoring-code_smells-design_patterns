use crate::health_check::health_check;
use crate::tiered_pricing::tiered_pricing;
use actix_web::web;

pub fn routes(cfg: &mut web::ServiceConfig) {
    cfg.route("/health-check", web::get().to(health_check))
        .route("/pricing", web::get().to(tiered_pricing));
}
