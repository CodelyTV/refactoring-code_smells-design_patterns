<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class User
{
    private const SPANISH_LANGUAGE = "es";

    private string $locale;
    private Age $age;

    public function __construct(string $locale, Age $age)
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
        return $this->age->isUnderage();
    }
}
