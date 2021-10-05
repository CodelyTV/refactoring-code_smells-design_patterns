<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

final class RepeatPurchase2
{
    public function __construct(private CartRepository $cartRepository)
    {
    }

    public function __invoke(CartId $id): void
    {
        $cart = $this->cartRepository->find($id);

        $newCart = new Cart(CartId::random());
        // To make this work we should make "items" property public
        foreach ($cart->items() as $item) {
            $newCart->add($item->product());
        }

        $this->cartRepository->save($newCart);
    }
}
