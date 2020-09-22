<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class User
{
    private Locale $locale;
    private Age $age;

    private function __construct(Locale $locale, Age $age)
    {
        $this->locale = $locale;
        $this->age    = $age;
    }

    public static function signUp(Locale $locale, Age $age): User
    {
        // …
        // Any kind of additional logic such as recording domain events, checking overall Aggregate consistency, etc.
        // …
        return new self($locale, $age);
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
