help: ## Show help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e "s/^[^:]*/`echo -e "\e[1m"`&`echo -e "\e[0m"`/" | sed -e "s/[^:]*##//"

env-file: ## Copy env file example if not exist env file
	@if [ ! -f .env ]; then cp .env.example .env; fi

up: env-file ## Run rust web server
	@docker-compose up -d

build: ## Run rust web server
	@docker-compose build --no-cache

stop: ## Stop rust web server
	@docker-compose stop

down: ## Remove rust container
	@docker-compose down

run-test: env-file ## Run test on new docker container (slow)
	docker-compose run --rm api cargo test

test: ## Execute test on running docker container
	docker-compose exec api cargo test
