<?php

declare(strict_types=1);

namespace CodelyTv\Domain;

final class Contract
{
    private string $id;
    private int $contractedPower;

    public function __construct(string $id, int $contractedPower)
    {
        $this->id = $id;
        $this->contractedPower = $contractedPower;
    }

    public function changePower(int $selectedPower): void
    {
        $this->contractedPower = $selectedPower;
    }

    public function power(): int
    {
        return $this->contractedPower;
    }

    public function id(): string
    {
        return $this->id;
    }
}
