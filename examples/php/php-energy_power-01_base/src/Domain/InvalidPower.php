<?php

declare(strict_types=1);

namespace CodelyTv\Domain;

use Exception;

class InvalidPower extends Exception
{
    public function __construct(int $power)
    {
        parent::__construct("Invalid power value $power");
    }
}
