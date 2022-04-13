FROM rust:1-alpine

WORKDIR /app

RUN apk update && apk add --no-cache musl-dev openssl-dev
RUN cargo install cargo-watch
