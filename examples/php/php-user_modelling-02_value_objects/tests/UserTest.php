<?php

declare(strict_types = 1);

namespace CodelyTv\UserModelling\Test;

use CodelyTv\UserModelling\User;
use PHPUnit\Framework\TestCase;

final class UserTest extends TestCase
{
    /** @test */
    public function should_detect_spanish_from_spain_as_spanish_language(): void
    {
        $user = new User("es_ES", 20);

        self::assertTrue($user->understandSpanish());
    }

    /** @test */
    public function should_not_detect_english_from_great_britain_as_spanish_language(): void
    {
        $user = new User("en_GB", 20);

        self::assertFalse($user->understandSpanish());
    }

    /** @test */
    public function should_detect_underage_users_until_18_years_old(): void
    {
        $user = new User("en_GB", 17);

        self::assertTrue($user->isUnderage());
    }

    /** @test */
    public function should_not_detect_underage_users_starting_from_18_years_old(): void
    {
        $user = new User("en_GB", 18);

        self::assertFalse($user->isUnderage());
    }
}
