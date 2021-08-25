<?php

declare(strict_types=1);

namespace CodelyTv\Email;

final class EmailNotifier
{
    private static ?EmailNotifier $instance = null;

    private function __construct()
    {
    }

    public static function instance(): EmailNotifier
    {
        if (!self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function sendSubscriptionEmail(string $to)
    {
        echo "Email sent to $to";
        require __DIR__ . '/subscription-email.php';
    }
}
