<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

final class CartLines
{
    /** @var CartLine[] */
    private array $lines = [];

    public function add(CartLine $line): void
    {
        $this->lines[$line->product()->toString()] = $line;
    }

    public function existsForProduct(ProductId $productId): bool
    {
        return array_key_exists($productId->toString(), $this->lines);
    }

    public function totalUnits(): Units
    {
        return array_reduce($this->lines, function(Units $units, CartLine $line) {
            return $units->sum($line->units());
        }, new Units(0));
    }

    public function count(): int
    {
        return count($this->lines);
    }

    public function remove(ProductId $productId): void
    {
        if (!$this->existsForProduct($productId)) {
            throw new ProductNotInCart();
        }

        unset($this->lines[$productId->toString()]);
    }

    public function total(): Price
    {
        return array_reduce($this->lines, function (Price $total, CartLine $line) {
            return $total->sum($line->total());
        }, new Price(0, Currency::EUR()));
    }

    public function clone(): CartLines
    {
        $newLines = clone $this;
        $this->lines = array_map(function (CartLine $line) {
            return $line->clone();
        }, $this->lines);
        return $newLines;
    }
}
