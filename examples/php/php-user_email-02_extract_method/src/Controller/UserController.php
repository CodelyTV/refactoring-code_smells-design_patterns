<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\User;
use InvalidArgumentException;

final class UserController
{
    public function post(string $emailAddress): User
    {
        $this->ensureEmailIsNotEmpty($emailAddress);
        $this->ensureEmailIsFormattedCorrectly($emailAddress);
        $this->ensureEmailHasCommonProvider($emailAddress);

        return new User($emailAddress);
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

    private function ensureEmailHasCommonProvider(string $emailAddress): void
    {
        if (!$this->emailHasCommonProvider($emailAddress)) {
            throw new InvalidArgumentException("The email address <$emailAddress> has not a common provider");
        }
    }

    private function emailHasCommonProvider(string $emailAddress): bool
    {
        return strpos($emailAddress, '@yahoo') || strpos($emailAddress, '@gmail') || strpos($emailAddress, '@outlook');
    }
}
