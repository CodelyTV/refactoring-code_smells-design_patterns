<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Symfony;

use JsonException;
use Symfony\Component\HttpFoundation\Response;

class ApiResponseResource
{
    private const JSON_CONTENT_TYPE = 'application/json';

    private int $statusCode;
    private array $data;
    private array $errors;
    private string $message;
    private bool $success;

    public function __construct(int $statusCode, array $data, array $errors, string $message, bool $success)
    {
        $this->statusCode = $statusCode;
        $this->data = $data;
        $this->errors = $errors;
        $this->message = $message;
        $this->success = $success;
    }

    /**
     * @return Response
     * @throws JsonException
     */
    public function getResponse(): Response
    {
        return new Response(
            json_encode(
                [
                    'data' => $this->data,
                    'meta' => [
                        'success' => $this->success,
                        'message' => $this->message,
                        'errors' => $this->errors
                    ]
                ],
                JSON_THROW_ON_ERROR
            ),
            $this->statusCode,
            ['Content-Type' => self::JSON_CONTENT_TYPE]
        );
    }
}
