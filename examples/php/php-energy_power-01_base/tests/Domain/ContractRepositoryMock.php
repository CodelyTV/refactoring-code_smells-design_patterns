<?php

declare(strict_types=1);

namespace CodelyTv\Tests\Domain;

use CodelyTv\Domain\Contract;
use CodelyTv\Domain\ContractRepository;

final class ContractRepositoryMock implements ContractRepository
{
    private ?Contract $contract = null;

    public function save(Contract $contract): void
    {
        $this->contract = $contract;
    }

    public function search(string $contractId): ?Contract
    {
        return $this->contract;
    }

    public function assertContractSaved(Contract $contract): void
    {
        \PHPUnit\Framework\assertEquals($contract, $this->contract);
    }

    public function returnOnSearch(Contract $contract): void
    {
        $this->contract = $contract;
    }
}
