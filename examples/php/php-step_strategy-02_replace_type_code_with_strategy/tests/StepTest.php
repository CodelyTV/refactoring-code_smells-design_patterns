<?php

declare(strict_types = 1);

namespace CodelyTv\StepStrategy\Test;

use CodelyTv\StepStrategy\Step;
use PHPUnit\Framework\TestCase;

final class StepTest extends TestCase
{
    /** @test */
    public function should_properly_calculate_video_step_estimated_completion_minutes(): void
    {
        $step = new Step("lerele", 0, 10, null);

        self::assertEquals(10, $step->estimatedCompletionMinutes());
    }

    /** @test */
    public function should_properly_calculate_quizz_step_estimated_completion_minutes(): void
    {
        $step = new Step("lerele", 1, null, [1, 2, 3]);

        self::assertEquals(9, $step->estimatedCompletionMinutes());
    }

    /** @test */
    public function should_properly_calculate_exercise_step_estimated_completion_minutes(): void
    {
        $step = new Step("lerele", 2, null, null);

        self::assertEquals(30, $step->estimatedCompletionMinutes());
    }
}
