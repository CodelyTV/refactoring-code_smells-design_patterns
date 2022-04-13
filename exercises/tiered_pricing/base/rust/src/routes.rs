use actix_web::web;
use crate::health_check::health_check;

pub fn routes(cfg: &mut web::ServiceConfig) {
    cfg.route("/health-check", web::get().to(health_check));
}
