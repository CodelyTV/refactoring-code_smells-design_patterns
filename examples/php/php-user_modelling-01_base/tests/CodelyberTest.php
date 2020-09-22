<?php

declare(strict_types = 1);

namespace CodelyTv\PhpBootstrapTest;

use CodelyTv\PhpBootstrap\Codelyber;
use PHPUnit\Framework\TestCase;

final class CodelyberTest extends TestCase
{
    /** @var Codelyber */
    private $codelyber;

    /** @var string */
    private $greeting;

    public function tearDown()
    {
        parent::tearDown();

        $this->codelyber = null;
        $this->greeting = null;
    }

    /** @test */
    public function shouldSayHelloWhenGreeting()
    {
        $this->givenACodelyber();

        $this->whenItGreets();

        $this->thenItShouldSayCodelyTv();
    }

    private function givenACodelyber()
    {
        $this->codelyber = new Codelyber("Javi");
    }

    private function whenItGreets()
    {
        $this->greeting = $this->codelyber->greet();
    }

    private function thenItShouldSayCodelyTv()
    {
        $this->assertEquals("CodelyTV", $this->greeting);
    }
}
