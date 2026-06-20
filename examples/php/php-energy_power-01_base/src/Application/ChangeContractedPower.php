<?php

declare(strict_types=1);

namespace CodelyTv\Application;

use CodelyTv\Domain\ContractNotFound;
use CodelyTv\Domain\ContractRepository;
use CodelyTv\Domain\InvalidPower;

final class ChangeContractedPower
{
    private ContractRepository $repository;

    public function __construct(ContractRepository $repository)
    {
        $this->repository = $repository;
    }

    public function run(string $contractId, int $newPower): void
    {
        $contract = $this->repository->search($contractId);
        if (!$contract) {
            throw new ContractNotFound($contractId);
        }

        $validNormalizedPowers = [
            1150,
            1725,
            2300,
            3450,
            4600,
            5750,
            6900,
            8050,
            9200
        ];

        if (!in_array($newPower, $validNormalizedPowers)) {
            throw new InvalidPower($newPower);
        }

        $contract->changePower($newPower);

        $this->repository->save($contract);
    }
}
