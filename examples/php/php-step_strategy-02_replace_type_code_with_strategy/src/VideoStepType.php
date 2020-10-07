<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class VideoStepType extends StepType
{
    private int $videoDurationInMinutes;

    public function __construct(int $videoDurationInMinutes)
    {
        $this->videoDurationInMinutes = $videoDurationInMinutes;
    }

    public function estimatedCompletionMinutes(): int
    {
        return $this->videoDurationInMinutes;
    }

    protected static function code(): int
    {
        return 0;
    }
}
