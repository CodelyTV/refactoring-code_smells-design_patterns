<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class User
{
    private Locale $locale;
    private Age $age;

    public function __construct(string $locale, Age $age)
    {
        $this->locale = new Locale($locale);
        $this->age    = $age;
    }

    public static function signUp(Locale $locale, Age $age)
    {
        return new self($locale->value(), $age);
    }

    public function understandSpanish(): bool
    {
        return $this->locale->understandSpanish();
    }

    public function isUnderage(): bool
    {
        return $this->age->isUnderage();
    }
}
