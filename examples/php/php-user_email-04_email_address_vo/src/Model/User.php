<?php

declare(strict_types=1);

namespace CodelyTv\Model;

use InvalidArgumentException;

final class User
{
    private EmailAddress $emailAddress;

    public function __construct(EmailAddress $emailAddress)
    {
        self::ensureEmailIsValid($emailAddress);

        $this->emailAddress = $emailAddress;
    }

    public static function ensureEmailIsValid(EmailAddress $emailAddress): void
    {
        if (!$emailAddress->emailHasCommonProvider()) {
            throw new InvalidArgumentException(
                "The email address <{$emailAddress->value()}> has not a common provider"
            );
        }
    }

    public function emailAddress(): EmailAddress
    {
        return $this->emailAddress;
    }
}
