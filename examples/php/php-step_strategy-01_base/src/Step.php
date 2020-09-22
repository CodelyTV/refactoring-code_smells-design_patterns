<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;
    private const QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES = 3;

    private const VIDEO_STEP_TYPE = 0;
    private const QUIZ_STEP_TYPE = 1;
    private const EXERCISE_STEP_TYPE = 2;

    private string $title;
    private int    $type;
    private ?int    $videoDurationInMinutes;
    private ?array  $quizQuestions;

    public function __construct(string $title, int $type, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        $this->title                  = $title;
        $this->type                   = $type;
        $this->videoDurationInMinutes = $videoDurationInMinutes;
        $this->quizQuestions          = $quizQuestions;
    }

    public function estimatedCompletionMinutes(): int
    {
        $estimation = 0;

        if ($this->type === self::VIDEO_STEP_TYPE) {
            $estimation = $this->videoDurationInMinutes;
        } elseif ($this->type === self::QUIZ_STEP_TYPE) {
            $estimation = self::QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES * count($this->quizQuestions);
        } elseif ($this->type === self::EXERCISE_STEP_TYPE) {
            $estimation = self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
        }

        return $estimation;
    }
}
