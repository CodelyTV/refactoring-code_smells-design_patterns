<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\Newsletter;

final class NewsletterController
{
    public function post(string $emailAddress): Newsletter
    {
        UserController::ensureEmailIsValid($emailAddress);

        return new Newsletter($emailAddress);
    }
}
