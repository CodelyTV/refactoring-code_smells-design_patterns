<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;
    private const QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES = 3;

    private string $title;
    private int    $type; // 0: Video, 1: Quizz, 2: Exercise
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

        if ($this->type === 0) { // Video
            $estimation = $this->videoDurationInMinutes;
        } elseif ($this->type === 1) { // Quizz
            $estimation = self::QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES * count($this->quizQuestions);
        } elseif ($this->type === 2) { // Exercise
            $estimation = self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
        }

        return $estimation;
    }
}
