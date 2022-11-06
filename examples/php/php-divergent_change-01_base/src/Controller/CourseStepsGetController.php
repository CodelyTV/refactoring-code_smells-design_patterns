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

        $results = '[';

        $csvLines = explode(PHP_EOL, $csv);

        foreach ($csvLines as $index => $row) {
            $row = str_getcsv($row);
            $type = $row[1];
            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            $id = $row[0];
            $durationVideo = $row[3];
            $durationQuiz = $row[2];

            $results .= json_encode(
                [
                    'id' => $id,
                    'type' => $type,
                    'duration' => $this->duration($type, $durationVideo, $durationQuiz),
                    'points' => $this->points($type, $durationVideo, $durationQuiz)
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
