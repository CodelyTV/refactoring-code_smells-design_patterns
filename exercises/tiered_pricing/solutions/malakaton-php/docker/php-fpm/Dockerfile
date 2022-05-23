FROM php:8.1.5-fpm-alpine as production

# Install needed modules to run the application
RUN apk update \
 && apk --quiet add \
    libzip-dev

# Add php extension to work with zip files
RUN docker-php-ext-install -j$(nproc) \
    zip

RUN apk --no-cache add pcre-dev ${PHPIZE_DEPS} \
    && pecl install -o -f redis \
    && rm -rf /tmp/pear \
    && docker-php-ext-enable redis \
    && apk del pcre-dev ${PHPIZE_DEPS}

# Install OPCACHE extension
RUN docker-php-ext-install opcache

WORKDIR /opt/app

# Install XDEBUG extension
RUN apk add --no-cache $PHPIZE_DEPS \
    && pecl install xdebug-3.1.4 \
    && docker-php-ext-enable xdebug


# Install Composer
RUN curl -sS https://getcomposer.org/installer | php -- --version=2.3.5 --install-dir=/usr/local/bin --filename=composer

# Add prestissimo for parallel composer downloads
#RUN composer global require "hirak/prestissimo"

# Copy source code into container
COPY ./src/ .

# Install production dependencies
RUN composer install

FROM production as development

# Install with dev dependencies
CMD sh -c "composer install && docker-php-entrypoint php-fpm"
