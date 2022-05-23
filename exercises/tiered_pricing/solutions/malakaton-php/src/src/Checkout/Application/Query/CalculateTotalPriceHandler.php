<?php

declare(strict_types=1);

namespace App\Checkout\Application\Query;

use App\Checkout\Domain\TieredPricing;
use App\Shared\Application\Query\QueryHandlerInterface;

final class CalculateTotalPriceHandler implements QueryHandlerInterface
{
    public function __invoke(CalculateTotalPriceQuery $query): array
    {
        return [
            'total_price' => (new TieredPricing($query->subscriptions()))->total()
        ];
    }
}
