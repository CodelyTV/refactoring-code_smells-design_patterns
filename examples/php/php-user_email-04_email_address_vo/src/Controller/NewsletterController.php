<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\EmailAddress;
use CodelyTv\Model\Newsletter;
use CodelyTv\Model\User;

final class NewsletterController
{
    public function post(string $emailAddress): Newsletter
    {
        User::ensureEmailIsValid(new EmailAddress($emailAddress));

        return new Newsletter($emailAddress);
    }
}
