<?php

declare(strict_types=1);

namespace CodelyTv\UserModelling;

use InvalidArgumentException;

final class Locale
{
    private const VALID_LOCALE_PATTERN = '/([a-z]{2})_([A-Z]{2})$/';
    private const SPANISH_LANGUAGE = "es";

    private string $languageCode;
    private string $countryCode;

    public function __construct(string $value)
    {
        if (!preg_match(self::VALID_LOCALE_PATTERN, $value, $matches)) {
            throw new InvalidArgumentException("Invalid locale");
        }

        $this->languageCode = $matches[1];
        $this->countryCode  = $matches[2];
    }

    public function value(): string
    {
        return $this->languageCode . '_' . $this->countryCode;
    }

    public function understandSpanish(): bool
    {
        return $this->languageCode === self::SPANISH_LANGUAGE;
    }
}
