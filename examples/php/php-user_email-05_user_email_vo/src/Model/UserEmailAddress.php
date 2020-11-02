<?php

declare(strict_types=1);

namespace CodelyTv\Model;

use InvalidArgumentException;

final class UserEmailAddress
{
    private EmailAddress $value;

    public function __construct(string $value)
    {
        $emailAddress = new EmailAddress($value);

        $this->ensureEmailIsValid($emailAddress);

        $this->value = $emailAddress;
    }

    public function ensureEmailIsValid(EmailAddress $emailAddress): void
    {
        if (!$emailAddress->emailHasCommonProvider()) {
            throw new InvalidArgumentException(
                "The email address <{$emailAddress->value()}> has not a common provider"
            );
        }
    }

    public function value(): string
    {
        return $this->value->value();
    }
}
