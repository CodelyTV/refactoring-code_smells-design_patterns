<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Http\Cli\Command;

use App\Shared\Application\Query\QueryBusInterface;
use App\Shared\Application\Query\QueryInterface;
use App\Shared\Application\Response\ResponseInterface;
use Symfony\Component\Console\Command\Command;

abstract class QueryCommand extends Command
{
    private QueryBusInterface $queryBus;

    public function __construct(QueryBusInterface $queryBus)
    {
        parent::__construct();

        $this->queryBus = $queryBus;
    }

    /**
     * @param QueryInterface $query
     * @return ResponseInterface|null
     *
     */
    protected function ask(QueryInterface $query): ResponseInterface
    {
        return $this->queryBus->ask($query);
    }
}
