<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class VideoStepType extends StepType
{
    private int $videoDurationInMinutes;

    public function __construct(int $videoDurationInMinutes)
    {
        $this->videoDurationInMinutes = $videoDurationInMinutes;
    }

    public function code(): int
    {
        return StepType::VIDEO_STEP_TYPE;
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
