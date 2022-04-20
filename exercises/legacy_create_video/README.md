# Legacy create video

Try to add new features to the legacy code

## User story

There is an HTTP API endpoint to create Codely videos.
When creating videos, we want to ensure that:

- The words "frontend", "Frontend" and "front-end" must be
  transformed to "Front-end".
- If the title contains any whitespace at the beginning or
the end, it must be removed.
- If the title contains a final dot, it must be removed.

## Exercise

Available languages:

- [PHP Symfony](base/php-symfony/README.md)