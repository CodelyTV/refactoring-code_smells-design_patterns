FROM composer:latest as composer

FROM php:7.2-fpm

RUN apt-get update && apt-get install -y \
    zlib1g-dev \
    libzip-dev \
    unzip

RUN docker-php-ext-install pdo_mysql && docker-php-ext-enable pdo_mysql

RUN pecl install xdebug && docker-php-ext-enable xdebug

COPY --from=composer /usr/bin/composer /usr/bin/composer