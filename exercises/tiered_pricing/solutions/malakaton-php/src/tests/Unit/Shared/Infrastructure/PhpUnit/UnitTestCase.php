<?php

declare(strict_types=1);

namespace App\Tests\Unit\Shared\Infrastructure\PhpUnit;

use App\Shared\Application\Query\QueryInterface;
use Mockery;
use Mockery\Adapter\Phpunit\MockeryTestCase;
use Mockery\MockInterface;

abstract class UnitTestCase extends MockeryTestCase
{
    protected function mock(string $className): MockInterface
    {
        return Mockery::mock($className);
    }

    protected function dispatchQuery(QueryInterface $command, callable $commandHandler)
    {
        return $commandHandler($command);
    }
}
