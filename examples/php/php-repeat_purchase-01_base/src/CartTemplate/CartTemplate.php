<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

interface CartTemplate
{
    public function createFromThisTemplate(): Cart;
}
