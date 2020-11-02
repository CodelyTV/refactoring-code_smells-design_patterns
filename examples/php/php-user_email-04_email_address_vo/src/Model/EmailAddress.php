<?php

declare(strict_types=1);

namespace CodelyTv\Model;

use InvalidArgumentException;

final class EmailAddress
{
    private string $value;

    public function __construct(string $value)
    {
        $this->ensureEmailIsNotEmpty($value);
        $this->ensureEmailIsFormattedCorrectly($value);

        $this->value = $value;
    }

    public function emailHasCommonProvider(): bool
    {
        return strpos($this->value(), '@yahoo')
               || strpos($this->value(), '@gmail')
               || strpos($this->value(), '@outlook');
    }

    public function value(): string
    {
        return $this->value;
    }

    private function ensureEmailIsNotEmpty(string $emailAddress): void
    {
        if ('' === $emailAddress) {
            throw new InvalidArgumentException('The email address is empty');
        }
    }

    private function ensureEmailIsFormattedCorrectly(string $emailAddress): void
    {
        if (!filter_var($emailAddress, FILTER_VALIDATE_EMAIL)) {
            throw new InvalidArgumentException("The email address <$emailAddress> is not valid");
        }
    }
}
