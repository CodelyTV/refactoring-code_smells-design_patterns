<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

use Ramsey\Uuid\Uuid;

final class CartId
{
    private string $cartId;

    public function __construct(string $cartId)
    {
        $this->cartId = $cartId;
    }

    public static function random(): self
    {
        return new self(Uuid::uuid4()->toString());
    }

    public function toString(): string
    {
        return $this->cartId;
    }
}
