<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Symfony\Exception;

use Throwable;

final class SymfonyException extends \Exception
{
    /**
     * SymfonyException constructor.
     * @param string $message
     * @param array $errors,
     * @param int $code
     * @param Throwable|null $previous
     * @throws \JsonException
     */
    public function __construct(string $message, array $errors, int $code = 500, Throwable $previous = null) {
        parent::__construct(
            json_encode([
                'message' => $message,
                'errors' => $errors,
            ], JSON_THROW_ON_ERROR),
            $code,
            $previous
        );
    }
}
