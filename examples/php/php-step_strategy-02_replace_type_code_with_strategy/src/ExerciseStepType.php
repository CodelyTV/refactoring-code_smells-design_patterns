<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class ExerciseStepType
{
    public function code(): int
    {
        return Step::EXERCISE_STEP_TYPE;
    }
}
