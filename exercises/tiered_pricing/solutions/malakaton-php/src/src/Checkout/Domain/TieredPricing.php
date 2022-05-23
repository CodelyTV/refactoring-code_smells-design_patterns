<?php

declare(strict_types=1);

namespace App\Checkout\Domain;

final class TieredPricing
{
    private const PRICE_FIRST_RANGE = 299;
    private const PRICE_SECOND_RANGE = 239;
    private const PRICE_THIRD_RANGE = 219;
    private const PRICE_FORTH_RANGE = 199;
    private const PRICE_LAST_RANGE = 149;

    private const MAX_SUBS_FIRST_RANGE = 2;
    private const MAX_SUBS_SECOND_RANGE = 10;
    private const MAX_SUBS_THIRD_RANGE = 25;
    private const MAX_SUBS_FOURTH_RANGE = 50;

    private const PRICE_RANGE = [
        self::MAX_SUBS_FIRST_RANGE => self::PRICE_FIRST_RANGE,
        self::MAX_SUBS_SECOND_RANGE => self::PRICE_SECOND_RANGE,
        self::MAX_SUBS_THIRD_RANGE => self::PRICE_THIRD_RANGE,
        self::MAX_SUBS_FOURTH_RANGE => self::PRICE_FORTH_RANGE
    ];

    private int $subscriptions;

    public function __construct(int $subscriptions)
    {
        $this->subscriptions = $subscriptions;
    }

    public function price(): int
    {
        foreach (self::PRICE_RANGE as $quantity => $price) {
            if ($this->subscriptions <= $quantity) {
                return $price;
            }
        }

        return self::PRICE_LAST_RANGE;
    }

    public function total(): int
    {
        $price = $this->price();

        return $price * $this->subscriptions;
    }
}
