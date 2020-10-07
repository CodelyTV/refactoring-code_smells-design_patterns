<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;
    private const QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES = 3;

    private string   $title;
    private StepType $type;
    private ?int     $videoDurationInMinutes;
    private ?array   $quizQuestions;

    public function __construct(string $title, int $typeCode, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        $this->title                  = $title;
        $this->type                   = StepType::fromPrimitive($typeCode, $videoDurationInMinutes, $quizQuestions);
        $this->videoDurationInMinutes = $videoDurationInMinutes;
        $this->quizQuestions          = $quizQuestions;
    }

    public function estimatedCompletionMinutes(): int
    {
        return $this->stepEstimatedCompletionMinutes();
    }

    public function stepEstimatedCompletionMinutes()
    {
        $estimation = 0;

        switch ($this->type->code()) {
            case StepType::VIDEO_STEP_TYPE:
                $estimation = $this->videoDurationInMinutes;
                break;
            case StepType::QUIZ_STEP_TYPE:
                $estimation = self::QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES * count($this->quizQuestions);
                break;
            case StepType::EXERCISE_STEP_TYPE:
                $estimation = self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
                break;
        }

        return $estimation;
    }
}
