<?php

declare(strict_types=1);

namespace CodelyTv\Domain;

interface ContractRepository
{
    public function save(Contract $contract): void;
    public function search(string $contractId): ?Contract;
}
