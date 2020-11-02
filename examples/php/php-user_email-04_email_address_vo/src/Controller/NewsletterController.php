<?php

declare(strict_types=1);

namespace CodelyTv\Controller;

use CodelyTv\Model\EmailAddress;
use CodelyTv\Model\Newsletter;

final class NewsletterController
{
    public function post(string $emailAddress): Newsletter
    {
        return new Newsletter(new EmailAddress($emailAddress));
    }
}
