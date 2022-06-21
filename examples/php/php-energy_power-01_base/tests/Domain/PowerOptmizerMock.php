<?php

declare(strict_types=1);

namespace CodelyTv\Tests\Domain;

use CodelyTv\Domain\PowerOptimizer;

final class PowerOptmizerMock implements PowerOptimizer
{
    private ?int $optimizedPower = null;

    public function optimize(): int
    {
        return $this->optimizedPower;
    }

    public function returnOnOptimize(int $optimizedPower): void
    {
        $this->optimizedPower = $optimizedPower;
    }
}
