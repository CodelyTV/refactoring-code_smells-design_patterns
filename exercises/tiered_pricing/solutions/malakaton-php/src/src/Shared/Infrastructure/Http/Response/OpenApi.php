<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Http\Response;

use App\Shared\Infrastructure\Symfony\ApiResponseResource;
use Symfony\Component\HttpFoundation\Response;

class OpenApi extends ApiResponseResource
{
    private function __construct(
        array $data = [],
        int $status = Response::HTTP_OK,
        array $errors = [],
        string $message = null,
        bool $success = true
    ) {
        parent::__construct($status, $data, $errors, $message, $success);
    }

    public static function fromPayload(array $payload, int $status): self
    {
        return new self($payload, $status);
    }

    public static function empty(int $status): self
    {
        return new self(null, $status);
    }

    public static function one(array $resource, int $status = Response::HTTP_OK, string $message = ''): self
    {
        return new self($resource, $status, [], $message);
    }

    public static function created(string $message = '', array $data = []): self
    {
        return new self(
            $data,
            Response::HTTP_CREATED,
            [],
            $message
        );
    }
}
