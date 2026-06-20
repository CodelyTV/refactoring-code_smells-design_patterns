#!/bin/bash

create_docker_image() {
  echo "Create docker image image"
  docker build . -t refactoring:latest
  echo "install libraries"
  docker run --rm --interactive --tty --volume $PWD:/app refactoring composer install
}
help() {
  echo "./scripts.sh create: Create the docker image"
  echo "./scripts.sh test: Run phpunit"
}
run_tests() {
  echo "run tests"
  docker run --rm --volume $PWD:/app refactoring php /app/vendor/bin/phpunit --colors="always" --no-logging --no-coverage ${args}
}

case $1 in
    removeImage)
        echo "remove docker image"
        docker rmi refactoring:latest
        ;;
    createImage)
        create_docker_image
        ;;
    test)
        run_tests
        ;;
    help)
        help
        ;;
    *)
        echo "Esta opción $1 no existe."
        help
        ;;
esac
