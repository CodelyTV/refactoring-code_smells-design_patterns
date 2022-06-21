<?php

namespace CodelyTv\Tests\Application;

use CodelyTv\Application\SignUp;
use CodelyTv\Domain\Contract;
use CodelyTv\Domain\InvalidPower;
use CodelyTv\Tests\Domain\ContractRepositoryMock;
use PHPUnit\Framework\TestCase;

class SignUpTest extends TestCase
{
    private ContractRepositoryMock $repository;
    private SignUp $signUp;

    protected function setUp(): void
    {
        parent::setUp();

        $this->signUp = new SignUp($this->repository());
    }

    /**
     * @test
     * @dataProvider powerDataProvider
     */
    public function shouldCreateAElectricityContract(int $power): void
    {
        $contractId = '1';

        $this->signUp->run($contractId, $power);

        $ExpectedContract = new Contract($contractId, $power);

        $this->repository->assertContractSaved($ExpectedContract);
    }

    /** @test */
    public function shouldThrowInvalidPowerErrorForNotNormalizedPowerValues(): void
    {
        $this->expectException(InvalidPower::class);

        $contractId = '1';
        $notNormalizedPower = 1234;

        $this->signUp->run($contractId, $notNormalizedPower);
    }

    protected function repository(): ContractRepositoryMock
    {
        return $this->repository = $this->repository ?? new ContractRepositoryMock();
    }

    public function powerDataProvider(): array
    {
        return [
            [1150],
            [1725],
            [2300],
            [3450],
            [4600],
            [5750],
            [6900],
            [8050],
            [9200]
        ];
    }
}
