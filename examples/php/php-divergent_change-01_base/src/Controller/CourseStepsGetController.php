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
        $csv = $this->platform->findCourseSteps($courseId);

        $results = '[';

        $csvLines = explode(PHP_EOL, $csv);

        foreach ($csvLines as $index => $row) {
            $row = str_getcsv($row);

            if (empty($csv)) {
                continue;
            }

            $id = $row[0];
            $type = $row[1];
            $durationVideo = $row[3];
            $durationQuiz = $row[2];

            $duration = 0;
            $points   = 0;

            if ($type === 'video') {
                $duration = $durationVideo * 1.1; // 1.1 = due to video pauses
            }
            if ($type === 'quiz') {
                $duration = $durationQuiz * 0.5; // 0.5 = time in minutes per question
            }

            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            if ($type === 'video') {
                $points = $durationVideo * 1.1 * 100;
            }

            if ($type === 'quiz') {
                $points = $durationQuiz * 0.5 * 10;
            }

            $results .= json_encode(
                [
                    'id' => $id,
                    'type' => $type,
                    'duration' => $duration,
                    'points' => $points
                ],
                JSON_THROW_ON_ERROR
            );

            if ($index !== count($csvLines) - 1) {
                $results .= ',';
            }
        }

        $results .= ']';

        return $results;
    }
}
