<?php

declare(strict_types=1);

namespace CodelyTv;

final class Debug
{
    private static ?Debug $instance = null;

    private bool $debugMode = false;

    private function __construct()
    {
    }

    public static function instance(): Debug
    {
        if (!self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function enableDebugMode(): void
    {
        $this->debugMode = true;
    }

    public function isDebugModeEnabled(): bool
    {
        return  $this->debugMode;
    }
}
