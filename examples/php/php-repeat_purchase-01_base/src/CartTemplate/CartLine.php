<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

final class CartLine
{
    private Product $product;
    private Units $units;

    public function __construct(Product $product, Units $units)
    {
        $this->product = $product;
        $this->units = $units;
    }

    public function product(): ProductId
    {
        return $this->product->id();
    }

    public function units(): Units
    {
        return $this->units;
    }

    public function total(): Price
    {
        return $this->productUnitPrice()->multiply($this->units->value());
    }

    private function productUnitPrice(): Price
    {
        return $this->product->unitPriceFor($this->units);
    }

    public function clone(): CartLine
    {
        $newCartLine = clone $this;
        $newCartLine->product = $this->product->clone();
        return $newCartLine;
    }
}
