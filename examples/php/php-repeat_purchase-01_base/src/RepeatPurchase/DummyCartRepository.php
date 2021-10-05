<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

final class DummyCartRepository implements CartRepository
{
    public function find(CartId $cartId): Cart
    {
        $oiliveOil = new Product(
            new ProductId('olive-oil'),
            'Aceite de oliva 1L',
            new Price(425, Currency::EUR())
        );

        $vinegar = new Product(
            new ProductId('vinegar'),
            'Vinegar 1L',
            new Price(125, Currency::EUR())
        );


        $salt = new Product(
            new ProductId('salt'),
            'Sal 1kg',
            new Price(110, Currency::EUR())
        );

        $cart = new Cart(new CartId('dummyCart'));

        $cart->add($oiliveOil, new Units(3));
        $cart->add($vinegar, new Units(3));
        $cart->add($salt, new Units(1));

        return $cart;
    }

    public function save(Cart $cartId): void
    {
    }
}
