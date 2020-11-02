<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\Newsletter;
use CodelyTv\Model\UserEmailAddress;

final class NewsletterController
{
    public function post(string $emailAddress): Newsletter
    {
        return new Newsletter(new UserEmailAddress($emailAddress));
    }
}
