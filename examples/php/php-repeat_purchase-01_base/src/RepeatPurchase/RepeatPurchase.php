<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

final class RepeatPurchase
{
    public function __construct(private CartRepository $cartRepository)
    {
    }

    public function __invoke(CartId $id): void
    {
        $cart = $this->cartRepository->find($id);
        $newCart = $cart->repeatPurchase();
        $this->cartRepository->save($newCart);
    }
}
