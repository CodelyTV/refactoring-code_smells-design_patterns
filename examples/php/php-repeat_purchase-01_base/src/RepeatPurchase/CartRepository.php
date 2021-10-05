<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

interface CartRepository
{
    public function find(CartId $cartId): Cart;

    public function save(Cart $cartId): void;
}
