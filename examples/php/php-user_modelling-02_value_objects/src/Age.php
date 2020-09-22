<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

use InvalidArgumentException;

final class Age
{
    private const UNDERAGE_UNTIL_AGE = 18;

    private int $value;

    public function __construct(int $value)
    {
        if ($value < 10) {
            throw new InvalidArgumentException("User too young");
        }

        $this->value = $value;
    }

    public function isUnderage(): bool
    {
        return $this->value < self::UNDERAGE_UNTIL_AGE;
    }
}
