<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

final class Units
{
    private int $units;

    public function __construct(int $units)
    {
        $this->units = $units;
    }

    public function value(): int
    {
        return $this->units;
    }

    public function sum(Units $other): self
    {
        return new self($this->units + $other->units);
    }

    public function greaterOrEqualTo(Units $other): bool
    {
        return $this->units >= $other->units;
    }
}
