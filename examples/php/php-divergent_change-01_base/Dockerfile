FROM php:7.4
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer
RUN apt-get update && apt-get install -y git zip unzip

COPY . app
WORKDIR /app
