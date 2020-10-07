<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class QuizStepType extends StepType
{
    public const QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES = 3;
    private array $quizQuestions;

    public function __construct(array $quizQuestions)
    {
        $this->quizQuestions = $quizQuestions;
    }

    public function code(): int
    {
        return StepType::QUIZ_STEP_TYPE;
    }
}
