<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class ExerciseStepType extends StepType
{
    public const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;

    public function code(): int
    {
        return StepType::EXERCISE_STEP_TYPE;
    }

    public function stepEstimatedCompletionMinutes(Step $instance): int
    {
        return self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
    }
}
