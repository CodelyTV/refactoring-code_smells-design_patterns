<?php

declare(strict_types=1);

namespace CodelyTv;

final class FeatureFlags
{
    private static ?FeatureFlags $instance = null;

    private array $flags = [];

    private function __construct()
    {
    }

    public static function instance(): FeatureFlags
    {
        if (!self::$instance) {
            self::$instance = new self();
        }
        return self::$instance;
    }

    public function set(string $flagName, bool $flagValue)
    {
        $this->flags[$flagName] = $flagValue;
    }

    public function activate(string $flagName): void
    {
        $this->set($flagName, true);
    }

    public function get(string $flagName): bool
    {
        if (!array_key_exists($flagName, $this->flags)) {
            return false;
        }

        return $this->flags[$flagName];
    }

    public function deactivateAll(): void
    {
        foreach ($this->flags as $name => $value) {
            $this->flags[$name] = false;
        }
    }
}
