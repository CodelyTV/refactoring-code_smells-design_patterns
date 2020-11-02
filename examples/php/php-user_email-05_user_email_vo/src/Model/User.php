<?php

declare(strict_types=1);

namespace CodelyTv\Model;

final class User
{
    private UserEmailAddress $emailAddress;

    public function __construct(UserEmailAddress $emailAddress)
    {
        $this->emailAddress = $emailAddress;
    }

    public function emailAddress(): UserEmailAddress
    {
        return $this->emailAddress;
    }
}
