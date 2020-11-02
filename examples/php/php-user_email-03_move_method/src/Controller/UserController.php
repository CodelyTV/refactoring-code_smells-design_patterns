<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\User;

final class UserController
{
    public function post(string $emailAddress): User
    {
        return new User($emailAddress);
    }
}
