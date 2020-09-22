<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

final class Locale
{
    private const SPANISH_LANGUAGE = "es";

    private string $value;

    public function __construct(string $value)
    {
        $this->value = $value;
    }

    public function value(): string
    {
        return $this->value;
    }

    public function understandSpanish(): bool
    {
        $language = substr($this->value, 0, 2);

        return $language === self::SPANISH_LANGUAGE;
    }
}
