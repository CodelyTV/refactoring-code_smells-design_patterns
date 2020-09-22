<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class ExerciseStepType extends StepType
{
    private const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;

    public function estimatedCompletionMinutes(): int
    {
        return self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
    }

    protected static function code(): int
    {
        return 2;
    }
}
