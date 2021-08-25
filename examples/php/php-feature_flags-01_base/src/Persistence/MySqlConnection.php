<?php

declare(strict_types=1);

namespace CodelyTv\Persistence;

use CodelyTv\FeatureFlags;
use CodelyTv\Flags;

final class MySqlConnection
{
    private static ?MySqlConnection $instance = null;

    private function __construct()
    {
    }

    public static function instance(): MySqlConnection
    {
        if (!self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function persist(string $email, ?string $name = null): void
    {
        $subscription = ['email' => $email];

        $flag = FeatureFlags::instance()->get(Flags::NEW_SUBSCRIPTION_PAGE_NAME);
        if ($flag) {
            $subscription['name'] = $name;
        }

        echo json_encode($subscription) . PHP_EOL;
    }
}
