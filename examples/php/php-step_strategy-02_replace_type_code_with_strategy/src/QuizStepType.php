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

    public function stepEstimatedCompletionMinutes(Step $instance): int
    {
        $estimation = 0;

        switch ($instance->type->code()) {
            case StepType::VIDEO_STEP_TYPE:
                $estimation = $instance->videoDurationInMinutes;
                break;
            case StepType::QUIZ_STEP_TYPE:
                $estimation = QuizStepType::QUIZ_STEP_QUESTION_DURATION_ESTIMATION_IN_MINUTES * count($instance->quizQuestions);
                break;
            case StepType::EXERCISE_STEP_TYPE:
                $estimation = ExerciseStepType::EXERCISE_STEP_DURATION_ESTIMATION_IN_MINUTES;
                break;
        }

        return $estimation;
    }
}
