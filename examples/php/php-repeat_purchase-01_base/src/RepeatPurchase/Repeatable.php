<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

interface Repeatable
{
    public function repeatPurchase(): Repeatable;
}
