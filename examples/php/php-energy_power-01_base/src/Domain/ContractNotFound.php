<?php

declare(strict_types=1);

namespace CodelyTv\Domain;

use Exception;

class ContractNotFound extends Exception
{
    public function __construct(string $contractId)
    {
        parent::__construct("Contract of id $contractId not found");
    }
}
