<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

use InvalidArgumentException;

abstract class StepType
{
    public static function fromPrimitive(int $code, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        switch ($code) {
            case VideoStepType::code():
                return new VideoStepType($videoDurationInMinutes);
            case QuizStepType::code():
                return new QuizStepType($quizQuestions);
            case ExerciseStepType::code():
                return new ExerciseStepType();
            default:
                throw new InvalidArgumentException("Unrecognized Step type code");
        }
    }

    abstract protected static function code(): int;

    abstract public function estimatedCompletionMinutes(): int;
}
