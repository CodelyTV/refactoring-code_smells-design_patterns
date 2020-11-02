<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\User;
use CodelyTv\Model\UserEmailAddress;

final class UserController
{
    public function post(string $emailAddress): User
    {
        return new User(new UserEmailAddress($emailAddress));
    }
}
