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
        if (empty($csv)) {
            return '[]';
        }

        $csvLines = explode(PHP_EOL, $csv);

        $steps = [];
        foreach ($csvLines as $row) {
            $row = str_getcsv($row);
            $type = $row[1];
            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            $durationInitialVideo = $row[3];
            $durationInitialQuiz = $row[2];
            $steps[] = [
                'id' => $row[0],
                'type' => $type,
                'duration' => $this->duration($type, $durationInitialVideo, $durationInitialQuiz),
                'points' => $this->points($type, $durationInitialVideo, $durationInitialQuiz)
            ];
        }

        $results = [];
        foreach ($steps as $step) {
            $results[] = json_encode($step, JSON_THROW_ON_ERROR);
        }

        $resultString = '[' . implode(',', $results) . ']';

        return $resultString;
    }

    private function duration(string $type, $durationVideo, $durationQuiz): float
    {
        $duration = 0;
        if ($type === 'video') {
            $duration = $durationVideo * 1.1; // 1.1 = due to video pauses
        }
        if ($type === 'quiz') {
            $duration = $durationQuiz * 0.5; // 0.5 = time in minutes per question
        }
        return $duration;
    }

    private function points(string $type, $durationVideo, $durationQuiz): float
    {
        $points = 0;
        if ($type === 'video') {
            $points = $durationVideo * 1.1 * 100;
        }
        if ($type === 'quiz') {
            $points = $durationQuiz * 0.5 * 10;
        }
        return $points;
    }
}
