<?php

declare(strict_types=1);

namespace App\Shared\Infrastructure\Http\Controller;

use App\Shared\Application\Query\QueryBusInterface;
use App\Shared\Application\Query\QueryInterface;
use App\Shared\Infrastructure\Http\Response\OpenApi;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;

abstract class QueryController
{
    private QueryBusInterface $queryBus;

    private UrlGeneratorInterface $router;

    public function __construct(QueryBusInterface $queryBus, UrlGeneratorInterface $router)
    {
        $this->queryBus = $queryBus;
        $this->router = $router;
    }

    /**
     * @param QueryInterface $query
     * @return array|null
     *
     */
    protected function ask(QueryInterface $query): array|null
    {
        return $this->queryBus->ask($query);
    }

    /**
     * @param array $resource
     * @param int $status
     * @return Response
     */
    protected function json(array $resource, int $status = Response::HTTP_OK): Response
    {
        return OpenApi::one($resource, $status)->getResponse();
    }

    /**
     * @param string $name
     * @param array $params
     * @return string
     */
    protected function route(string $name, array $params = []): string
    {
        return $this->router->generate($name, $params);
    }
}
