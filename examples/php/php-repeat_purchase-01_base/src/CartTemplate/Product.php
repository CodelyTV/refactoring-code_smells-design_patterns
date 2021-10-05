<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

use Ramsey\Uuid\Uuid;

final class Product
{
    public function __construct(
        private ProductId $id,
        private string $name,
        private Price $unitPrice
    ) {
    }

    public function id(): ProductId
    {
        return $this->id;
    }

    public function name(): string
    {
        return $this->name;
    }

    public function unitPrice(): Price
    {
        return $this->unitPrice;
    }

    public function clone(): Product
    {
        $newProduct = clone $this;
        $newProduct->id = new ProductId(Uuid::uuid4()->toString());
        return  $newProduct;
    }
}
