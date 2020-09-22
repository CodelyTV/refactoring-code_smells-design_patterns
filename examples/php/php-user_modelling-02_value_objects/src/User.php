<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class User
{
    private const SPANISH_LANGUAGE = "es";
    private const UNDERAGE_UNTIL_AGE = 18;

    private string $locale;
    private int    $age;

    public function __construct(string $locale, int $age)
    {
        $this->locale = $locale;
        $this->age    = $age;
    }

    public function understandSpanish(): bool
    {
        $language = substr($this->locale, 0, 2);

        return $language === self::SPANISH_LANGUAGE;
    }

    public function isUnderage(): bool
    {
        return $this->age < self::UNDERAGE_UNTIL_AGE;
    }
}
