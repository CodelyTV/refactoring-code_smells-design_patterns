<?php

declare(strict_types=1);

namespace App\Checkout\Application\Query;

use App\Shared\Application\Query\QueryInterface;

final class CalculateTotalPriceQuery implements QueryInterface
{
    private int $subscriptions;

    public function __construct(int $subscriptions)
    {
        $this->subscriptions = $subscriptions;
    }

    public function subscriptions(): int
    {
        return $this->subscriptions;
    }
}
