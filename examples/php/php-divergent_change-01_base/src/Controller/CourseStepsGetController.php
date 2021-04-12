<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Controller;

use CodelyTv\DivergentChange\Platform;

final class CourseStepsGetController
{
    private Platform $platform;

    public function __construct(Platform $platform)
    {
        $this->platform = $platform;
    }

    public function get(string $courseId): string
    {
        $csvSteps = $this->platform->findCourseSteps($courseId);

        $results = '[';

        foreach ($csvSteps as $index => $row) {
            $type     = $row['type'];
            $duration = 0;
            $points   = 0;

            if ($type === 'video') {
                $duration = $row['duration'] * 1.1; // 1.1 = due to video pauses
            }

            if ($type === 'quiz') {
                $duration = $row['questions'] * 0.5; // 0.5 = time in minutes per question
            }

            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            if ($type === 'video') {
                $points = $row['duration'] * 1.1 * 100;
            }

            if ($type === 'quiz') {
                $points = $row['questions'] * 0.5 * 10;
            }

            $results .= json_encode(
                [
                    'id' => $row['id'],
                    'type' => $row['type'],
                    'duration' => $duration,
                    'points' => $points
                ],
                JSON_THROW_ON_ERROR
            );

            if ($index !== count($csvSteps) - 1) {
                $results .= ',';
            }

        }

        $results .= ']';

        return $results;
    }
}
