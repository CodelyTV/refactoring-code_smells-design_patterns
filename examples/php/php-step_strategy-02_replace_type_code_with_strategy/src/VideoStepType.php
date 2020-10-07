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

    public function code(): int
    {
        return Step::VIDEO_STEP_TYPE;
    }
}
