<?php

declare(strict_types=1);

namespace App\Tests\Integration\Shared\Application;

use App\Shared\Application\Query\QueryBusInterface;
use App\Shared\Application\Query\QueryInterface;
use Symfony\Bundle\FrameworkBundle\Test\KernelTestCase;

abstract class ApplicationTestCase extends KernelTestCase
{
    private ?QueryBusInterface $queryBus;

    protected function setUp(): void
    {
        self::bootKernel();

        $this->queryBus = $this->service(QueryBusInterface::class);
    }

    /**
     * @param QueryInterface $query
     * @return mixed
     *
     */
    protected function ask(QueryInterface $query)
    {
        return $this->queryBus->ask($query);
    }

    /**
     * @param string $serviceId
     * @return object|null
     */
    protected function service(string $serviceId): ?object
    {
        return self::$container->get($serviceId);
    }

    protected function tearDown(): void
    {
        parent::tearDown();
        $this->queryBus = null;
    }
}
