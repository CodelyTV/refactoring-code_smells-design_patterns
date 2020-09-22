<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

use InvalidArgumentException;

abstract class StepType
{
    public const VIDEO_STEP_TYPE = 0;
    public const QUIZ_STEP_TYPE = 1;
    public const EXERCISE_STEP_TYPE = 2;

    public static function fromPrimitive(int $code, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        switch ($code) {
            case self::VIDEO_STEP_TYPE:
                return new VideoStepType($videoDurationInMinutes);
            case self::QUIZ_STEP_TYPE:
                return new QuizStepType($quizQuestions);
            case self::EXERCISE_STEP_TYPE:
                return new ExerciseStepType();
            default:
                throw new InvalidArgumentException("Unrecognized Step type code");
        }
    }

    abstract public function code(): int;

    abstract public function stepEstimatedCompletionMinutes(Step $instance): int;
}
