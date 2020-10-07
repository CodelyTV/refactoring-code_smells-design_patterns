<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

use InvalidArgumentException;

abstract class StepType
{
    public static function fromPrimitive(int $code, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        switch ($code) {
            case Step::VIDEO_STEP_TYPE:
                return new VideoStepType($videoDurationInMinutes);
            case Step::QUIZ_STEP_TYPE:
                return new QuizStepType($quizQuestions);
            case Step::EXERCISE_STEP_TYPE:
                return new ExerciseStepType();
            default:
                throw new InvalidArgumentException("Unrecognized Step type code");
        }
    }

    abstract public function code(): int;
}
