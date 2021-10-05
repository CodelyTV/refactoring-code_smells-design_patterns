<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

final class ProductId
{
    private string $productId;

    public function __construct(string $productId)
    {
        $this->productId = $productId;
    }

    public function toString(): string
    {
        return $this->productId;
    }
}
