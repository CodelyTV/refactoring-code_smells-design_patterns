<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

final class CreateCartFromTemplate
{
    public function __construct(private CartRepository $cartRepository)
    {
    }

    public function __invoke(CartId $id): void
    {
        $template = $this->cartRepository->find($id);
        $cart = $template->createFromThisTemplate();
        $this->cartRepository->save($cart);
    }
}
