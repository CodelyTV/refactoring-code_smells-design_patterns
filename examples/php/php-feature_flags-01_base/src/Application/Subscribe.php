<?php

declare(strict_types=1);

namespace CodelyTv\Application;

use CodelyTv\Debug;
use CodelyTv\Email\EmailNotifier;
use CodelyTv\FeatureFlags;
use CodelyTv\Flags;
use CodelyTv\Persistence\MySqlConnection;

final class Subscribe
{
    public function __invoke(string $email, ?string $name = null): void
    {
        if (Debug::instance()->isDebugModeEnabled()) {
            FeatureFlags::instance()->deactivateAll();
        }

        $flag = FeatureFlags::instance()->get(Flags::NEW_SUBSCRIPTION_PAGE_NAME);

        if ($flag) {
            // The new subscription added a "name" field
            MySqlConnection::instance()->persist($email, $name);
        } else {
            MySqlConnection::instance()->persist($email);
        }

        EmailNotifier::instance()->sendSubscriptionEmail($email);
    }
}
