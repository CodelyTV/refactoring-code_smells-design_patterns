mod routes;
mod health_check;

use actix_web::{App, HttpServer};
use routes::routes;

const API_IP: &str = env!("API_IP");
const API_PORT: &str = env!("API_PORT");

fn get_address() -> String {
    format!("{}:{}", API_IP, API_PORT)
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    let server = HttpServer::new( || {
            App::new()
                .configure(routes)
        })
        .bind(get_address());

    match server {
        Ok(server) => {
            println!("🚀 Server running at {}", get_address());
            server.run().await
        }
        Err(_) => panic!("🔥 Coul not start the server at {}", get_address())
    }
}
