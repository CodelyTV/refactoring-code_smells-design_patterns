<?php

declare(strict_types = 1);

namespace CodelyTv\UserModelling\Test;

use CodelyTv\UserModelling\User;
use PHPUnit\Framework\TestCase;

final class UserTest extends TestCase
{
    /** @test */
    public function shouldSayHelloWhenGreeting()
    {
        $user = new User("es_ES", 20);

        self::assertEquals("es_ES", $user->locale());
    }
}
