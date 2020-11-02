<?php

declare(strict_types=1);

namespace CodelyTv\Model;

use InvalidArgumentException;

final class User
{
    private string $emailAddress;

    public function __construct(string $emailAddress)
    {
        self::ensureEmailIsValid($emailAddress);

        $this->emailAddress = $emailAddress;
    }

    public static function ensureEmailIsValid(string $emailAddress): void
    {
        self::ensureEmailIsNotEmpty($emailAddress);
        self::ensureEmailIsFormattedCorrectly($emailAddress);
        self::ensureEmailHasCommonProvider($emailAddress);
    }

    private static function ensureEmailIsNotEmpty(string $emailAddress): void
    {
        if ('' === $emailAddress) {
            throw new InvalidArgumentException('The email address is empty');
        }
    }

    private static function ensureEmailIsFormattedCorrectly(string $emailAddress): void
    {
        if (!filter_var($emailAddress, FILTER_VALIDATE_EMAIL)) {
            throw new InvalidArgumentException("The email address <$emailAddress> is not valid");
        }
    }

    private static function emailHasCommonProvider(string $emailAddress): bool
    {
        return strpos($emailAddress, '@yahoo') || strpos($emailAddress, '@gmail') || strpos($emailAddress, '@outlook');
    }

    private static function ensureEmailHasCommonProvider(string $emailAddress): void
    {
        if (!self::emailHasCommonProvider($emailAddress)) {
            throw new InvalidArgumentException("The email address <$emailAddress> has not a common provider");
        }
    }

    public function emailAddress(): string
    {
        return $this->emailAddress;
    }
}
