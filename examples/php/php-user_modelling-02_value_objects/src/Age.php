<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class Age
{
    private const UNDERAGE_UNTIL_AGE = 18;

    private int $value;

    public function __construct(int $value)
    {
        $this->value = $value;
    }

    public function isUnderage(): bool
    {
        return $this->value < self::UNDERAGE_UNTIL_AGE;
    }
}
