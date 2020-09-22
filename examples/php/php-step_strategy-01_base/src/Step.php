<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private const EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES = 30;
    private const QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES = 3;

    public const VIDEO_STEP_TYPE = 0;
    public const QUIZ_STEP_TYPE = 1;
    public const EXERCISE_STEP_TYPE = 2;

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
        $estimation = 0;

        switch ($this->type->code()) {
            case self::VIDEO_STEP_TYPE:
                $estimation = $this->videoDurationInMinutes;
                break;
            case self::QUIZ_STEP_TYPE:
                $estimation = self::QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES * count($this->quizQuestions);
                break;
            case self::EXERCISE_STEP_TYPE:
                $estimation = self::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
                break;
        }

        return $estimation;
    }
}
