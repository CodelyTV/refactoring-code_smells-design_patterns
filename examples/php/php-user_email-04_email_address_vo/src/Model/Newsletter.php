<?php

declare(strict_types=1);

namespace CodelyTv\Model;

final class Newsletter
{
    private EmailAddress $emailAddress;

    public function __construct(EmailAddress $emailAddress)
    {
        User::ensureEmailIsValid($emailAddress);

        $this->emailAddress = $emailAddress;
    }

    public function emailAddress(): EmailAddress
    {
        return $this->emailAddress;
    }
}
