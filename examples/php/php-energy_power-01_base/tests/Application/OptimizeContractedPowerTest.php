<?php

namespace CodelyTv\Tests\Application;

use CodelyTv\Application\OptimizeContractedPower;
use CodelyTv\Domain\Contract;
use CodelyTv\Domain\ContractNotFound;
use CodelyTv\Tests\Domain\ContractRepositoryMock;
use CodelyTv\Tests\Domain\PowerOptmizerMock;
use PHPUnit\Framework\TestCase;

class OptimizeContractedPowerTest extends TestCase
{
    private ContractRepositoryMock  $repository;
    private PowerOptmizerMock       $powerOptimizer;
    private OptimizeContractedPower $optimizeContractedPower;

    protected function setUp(): void
    {
        parent::setUp();

        $this->repository              = new ContractRepositoryMock();
        $this->powerOptimizer          = new PowerOptmizerMock();
        $this->optimizeContractedPower = new OptimizeContractedPower($this->repository, $this->powerOptimizer);
    }

    /**
     * @test
     * @dataProvider powerOptimizedDataProvider
     */
    public function shouldChangeContractedPowerFromContract(int $optimizedPower, int $initialPower, int $newPower): void
    {
        $contractId = '1';
        $contract   = new Contract($contractId, $initialPower);

        $this->repository->returnOnSearch($contract);
        $this->powerOptimizer->returnOnOptimize($optimizedPower);

        $this->optimizeContractedPower->run($contractId);
        $this->repository->assertContractSaved($contract);

        $this->assertEquals($contract->power(), $newPower);
    }

    /** @test */
    public function shouldThrowContractNotFoundError(): void
    {
        $this->expectException(ContractNotFound::class);

        $this->optimizeContractedPower->run('1');
    }

    public function powerOptimizedDataProvider(): array
    {
        return [
            [1150, 1150, 1150],
            [1151, 1150, 1725],
            [1725, 1150, 1725],
            [1726, 1150, 2300],
            [2300, 1725, 2300],
            [2301, 1725, 3450],
            [3450, 2300, 3450],
            [3451, 2300, 4600],
            [4600, 3450, 4600],
            [4601, 3450, 5750],
            [5750, 4600, 5750],
            [5751, 4600, 6900],
            [6900, 5750, 6900],
            [6901, 5750, 8050],
            [8050, 6900, 8050],
            [8051, 6900, 9200],
        ];
    }
}
