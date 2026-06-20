<?php

declare(strict_types=1);

namespace CodelyTv\Application;

use CodelyTv\Domain\ContractNotFound;
use CodelyTv\Domain\ContractRepository;
use CodelyTv\Domain\PowerOptimizer;

final class OptimizeContractedPower
{
    private ContractRepository $repository;
    private PowerOptimizer $optimizer;

    public function __construct(ContractRepository $repository, PowerOptimizer $optimizer)
    {
        $this->repository = $repository;
        $this->optimizer = $optimizer;
    }

    public function run(string $contractId): void
    {
        $contract = $this->repository->search($contractId);
        if (!$contract) {
            throw new ContractNotFound($contractId);
        }

        $optimizedPower = $this->optimizer->optimize();

        if ($optimizedPower <= 1150) {
            $power = 1150;
        } elseif ($optimizedPower <= 1725) {
            $power = 1725;
        } elseif ($optimizedPower <= 2300) {
            $power = 2300;
        } elseif ($optimizedPower <= 3450) {
            $power = 3450;
        } elseif ($optimizedPower <= 4600) {
            $power = 4600;
        } elseif ($optimizedPower <= 5750) {
            $power = 5750;
        } elseif ($optimizedPower <= 6900) {
            $power = 6900;
        } elseif ($optimizedPower <= 8050) {
            $power = 8050;
        } else {
            $power = 9200;
        }

        $contract->changePower($power);

        $this->repository->save($contract);
    }
}
