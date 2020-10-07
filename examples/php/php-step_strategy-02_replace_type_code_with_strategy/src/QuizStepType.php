<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class QuizStepType extends StepType
{
    private array $quizQuestions;

    public function __construct(array $quizQuestions)
    {
        $this->quizQuestions = $quizQuestions;
    }

    public function code(): int
    {
        return Step::QUIZ_STEP_TYPE;
    }
}
