<?php

declare(strict_types=1);

namespace CodelyTv\Tests;

use PHPUnit\Framework\TestCase;

final class DummyTest extends TestCase
{
    /** @test */
    public function itShouldAssertTrue(): void
    {
        $this->assertTrue(true);
    }
}
