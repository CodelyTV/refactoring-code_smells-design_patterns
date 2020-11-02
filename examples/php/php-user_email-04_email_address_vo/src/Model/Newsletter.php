<?php

declare(strict_types=1);

namespace CodelyTv\Model;

final class Newsletter
{
    private string $emailAddress;

    public function __construct(string $emailAddress)
    {
        $this->emailAddress = $emailAddress;
    }

    public function emailAddress(): string
    {
        return $this->emailAddress;
    }
}
