<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class User
{
    private string $locale;
    private int    $age;

    public function __construct(string $locale, int $age)
    {
        $this->locale = $locale;
        $this->age    = $age;
    }

    public function locale(): string
    {
        return $this->locale;
    }

    public function age(): int
    {
        return $this->age;
    }
}
