<?php

declare(strict_types=1);

namespace CodelyTv\CartTemplate;

final class Currency
{
    private const EUR = 'EUR';
    private const USD = 'USD';

    private const SYMBOLS = [
        'EUR' => '€',
        'USD' => '$'
    ];

    private string $currency;

    private function __construct(string $currency)
    {
        $this->currency = $currency;
    }

    public static function EUR(): self
    {
        return new self(self::EUR);
    }

    public static function USD()
    {
        return new self(self::USD);
    }

    public function symbol()
    {
        return self::SYMBOLS[$this->currency];
    }

    public function toString(): string
    {
        return $this->currency;
    }

    public function equalTo(Currency $other): bool
    {
        return $this->currency === $other->currency;
    }
}
