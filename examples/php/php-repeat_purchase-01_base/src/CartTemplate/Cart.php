<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

final class Cart implements CartTemplate
{
    private CartId $id;
    private CartLines $lines;

    public function __construct(CartId $id)
    {
        $this->id = $id;
        $this->lines = new CartLines();
    }

    public function id(): CartId
    {
        return $this->id;
    }

    public function itemCount(): int
    {
        return $this->lines->totalUnits()->value();
    }

    public function hasProduct(ProductId $productId): bool
    {
        return $this->lines->existsForProduct($productId);
    }

    public function add(Product $product, Units $units): void
    {
        $this->lines->add(new CartLine($product, $units));
    }

    public function remove(ProductId $productId): void
    {
        $this->lines->remove($productId);
    }

    public function total(): Price
    {
        return $this->lines->total();
    }

    public function createFromThisTemplate(): Cart
    {
        return $this->clone();
    }

    private function clone(): Cart
    {
        $newCart = clone $this;
        $newCart->id = CartId::random();
        $newCart->lines = $this->lines->clone();
        return $newCart;
    }
}
