<?php

declare(strict_types=1);

namespace CodelyTv\Tests\Controller;

use CodelyTv\Controller\NewsletterController;
use CodelyTv\Model\EmailAddress;
use CodelyTv\Model\Newsletter;
use InvalidArgumentException;
use PHPUnit\Framework\TestCase;

final class NewsletterControllerTest extends TestCase
{
    /** @test */
    public function it_should_create_a_valid_newsletter(): void
    {
        $controller = new NewsletterController();

        $emailAddress = 'codely@gmail.com';

        self::assertEquals(new Newsletter(new EmailAddress('codely@gmail.com')), $controller->post($emailAddress));
    }

    /** @test */
    public function it_should_not_create_a_newsletter_with_an_empty_email(): void
    {
        $controller = new NewsletterController();

        $emailAddress = '';

        $this->expectExceptionObject(new InvalidArgumentException('The email address is empty'));

        $controller->post($emailAddress);
    }

    /** @test */
    public function it_should_not_create_a_newsletter_with_an_invalid_formatted_email(): void
    {
        $controller = new NewsletterController();

        $emailAddress = 'codely[at]gmail.com';

        $this->expectExceptionObject(new InvalidArgumentException("The email address <$emailAddress> is not valid"));

        $controller->post($emailAddress);
    }

    /** @test */
    public function it_should_not_create_a_newsletter_with_a_non_common_email_provider(): void
    {
        $controller = new NewsletterController();

        $emailAddress = 'codely@clubdefansdejavi.io';

        $this->expectExceptionObject(
            new InvalidArgumentException("The email address <$emailAddress> has not a common provider")
        );

        $controller->post($emailAddress);
    }
}
