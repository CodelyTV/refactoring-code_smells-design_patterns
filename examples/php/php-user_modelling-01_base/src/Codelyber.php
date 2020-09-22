<?php

declare(strict_types = 1);

namespace CodelyTv\PhpBootstrap;

final class Codelyber
{
    /** string */
    private const GREETING = "CodelyTV";

    /** @var string */
    private $name;

    public function __construct(string $aName)
    {
        $this->name = $aName;
    }

    public function name(): string
    {
        return $this->name;
    }

    public function greet(): string
    {
        return self::GREETING;
    }
}
