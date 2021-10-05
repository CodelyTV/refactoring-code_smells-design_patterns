<?php

declare(strict_types=1);

namespace CodelyTv\RepeatPurchase;

use InvalidArgumentException;

final class Price
{
    private int $amount;
    private Currency $currency;

    public function __construct(int $amount, Currency $currency)
    {
        $this->amount = $amount;
        $this->currency = $currency;
    }

    public function currency(): Currency
    {
        return $this->currency;
    }

    public function sum(Price $other): self
    {
        return new self($this->amount + $other->amount, $this->currency);
    }

    public function multiply(int $value): self
    {
        return new self($value * $this->amount, $this->currency);
    }

    public function convert(ExchangeRate $exchangeRate): self
    {
        if (!$this->currency->equalTo($exchangeRate->from())) {
            throw new InvalidArgumentException('Invalid exchange rate for conversion');
        }

        return new self((int)($this->amount * $exchangeRate->value()), $exchangeRate->to());
    }

    public function toString(): string
    {
        return number_format($this->amount/100, 2) . $this->currency->symbol();
    }
}
