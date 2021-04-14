<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Controller;

use CodelyTv\DivergentChange\Platform;

final class CourseStepsGetController
{
    const VIDEO_DURATION_PAUSES_MULTIPLIER = 1.1;
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

            $type     = $row[1];
            $stepDuration = 0;
            $points   = 0;

            $videoDuration = $row[3];
            if ($type === 'video') {
                $stepDuration = $videoDuration * self::VIDEO_DURATION_PAUSES_MULTIPLIER;
            }

            if ($type === 'quiz') {
                $stepDuration = $row[2] * 0.5; // 0.5 = time in minutes per question
            }

            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            if ($type === 'video') {
                $points = $stepDuration * 100;
            }

            if ($type === 'quiz') {
                $points = $row[2] * 0.5 * 10;
            }

            $results .= json_encode(
                [
                    'id' => $row[0],
                    'type' => $row[1],
                    'duration' => $stepDuration,
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
