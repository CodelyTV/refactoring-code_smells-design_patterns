<?php

namespace CodelyTv\Tests\Application;

use CodelyTv\Application\ChangeContractedPower;
use CodelyTv\Domain\Contract;
use CodelyTv\Domain\ContractNotFound;
use CodelyTv\Domain\InvalidPower;
use CodelyTv\Tests\Domain\ContractRepositoryMock;
use PHPUnit\Framework\TestCase;

class ChangeContractedPowerTest extends TestCase
{
    private ContractRepositoryMock $repository;
    private ChangeContractedPower  $changeContractedPower;

    protected function setUp(): void
    {
        parent::setUp();

        $this->repository            = new ContractRepositoryMock();
        $this->changeContractedPower = new ChangeContractedPower($this->repository);
    }

    /**
     * @test
     * @dataProvider powerChangeDataProvider
     */
    public function shouldChangeContractedPower(int $initialPower, int $newPower): void
    {
        $contractId = '1';
        $contract   = new Contract($contractId, $initialPower);
        $this->repository->returnOnSearch($contract);

        $this->changeContractedPower->run($contractId, $newPower);

        $this->assertEquals($newPower, $contract->power());
    }

    /**
     * @test
     */
    public function shouldThrowInvalidPowerErrorForNotNormalizedPowerValues(): void
    {
        $this->expectException(InvalidPower::class);

        $contractId         = '1';
        $notNormalizedPower = 1234;
        $contract           = new Contract($contractId, $notNormalizedPower);
        $this->repository->returnOnSearch($contract);

        $this->changeContractedPower->run($contractId, $notNormalizedPower);
    }

    /** @test */
    public function shouldThrowContractNotFoundError(): void
    {
        $this->expectException(ContractNotFound::class);

        $contractId         = '1';
        $notNormalizedPower = 1234;
        
        $this->changeContractedPower->run($contractId, $notNormalizedPower);
    }

    public function powerChangeDataProvider(): array
    {
        return [
            [1150, 1725],
            [1725, 2300],
            [2300, 3450],
            [3450, 4600],
            [4600, 5750],
            [5750, 6900],
            [6900, 8050],
            [8050, 9200],
            [9200, 1150],
            [1150, 1150],
        ];
    }
}
