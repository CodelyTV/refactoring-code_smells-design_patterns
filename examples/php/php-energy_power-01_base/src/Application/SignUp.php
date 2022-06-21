<?php

declare(strict_types=1);

namespace CodelyTv\Application;

use CodelyTv\Domain\Contract;
use CodelyTv\Domain\ContractRepository;
use CodelyTv\Domain\InvalidPower;

final class SignUp
{
    private ContractRepository $repository;

    public function __construct(ContractRepository $repository)
    {
        $this->repository = $repository;
    }

    public function run(string $contractId, int $power): void
    {
        if ($power !== 1150 &&
            $power !== 1725 &&
            $power !== 2300 &&
            $power !== 3450 &&
            $power !== 4600 &&
            $power !== 5750 &&
            $power !== 6900 &&
            $power !== 8050 &&
            $power !== 9200) {
            throw new InvalidPower($power);
        }

        $contract = new Contract($contractId, $power);

        $this->repository->save($contract);
    }
}
