<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\EmailAddress;
use CodelyTv\Model\User;

final class UserController
{
    public function post(string $emailAddress): User
    {
        return new User(new EmailAddress($emailAddress));
    }
}
