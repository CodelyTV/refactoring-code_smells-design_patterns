<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Controller;

use CodelyTv\DivergentChange\Platform;

final class CourseStepsGetController
{
    private const VIDEO_TYPE = 'video';
    private const QUIZ_TYPE = 'quiz';
    private const DURATION_VIDEO_MINUTES = 1.1;
    private const DURATION_QUIZ_MINUTES = 0.5;
    private const VIDEO_POINTS_PER_MINUTE = 100;
    private const QUIZ_POINTS_PER_MINUTE = 10;

    private Platform $platform;

    public function __construct(Platform $platform)
    {
        $this->platform = $platform;
    }

    public function get(string $courseId): string
    {
        $csv = $this->platform->findCourseSteps($courseId);
        $steps = $this->createSteps($csv);
        return $this->serialize($steps);
    }

    private function serialize(array $steps): string
    {
        $results = [];
        foreach ($steps as $step) {
            $results[] = json_encode($step, JSON_THROW_ON_ERROR);
        }
        return '[' . implode(',', $results) . ']';
    }

    private function createSteps(string $csv): array
    {
        $csvLines = explode(PHP_EOL, $csv);
        $steps = [];
        foreach ($csvLines as $row) {
            $row = str_getcsv($row);
            $type = $row[1];
            if (in_array($type, [self::VIDEO_TYPE, self::QUIZ_TYPE], true)) {
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
        return $steps;
    }

    private function duration(string $type, float $durationVideo, float $durationQuiz): float
    {
        if ($type === self::VIDEO_TYPE) {
            return $durationVideo * self::DURATION_VIDEO_MINUTES;
        }
        return $durationQuiz * self::DURATION_QUIZ_MINUTES;
    }

    private function points(string $type, float $durationVideo, float $durationQuiz): float
    {
        if ($type === self::VIDEO_TYPE) {
            return $durationVideo * self::DURATION_VIDEO_MINUTES * self::VIDEO_POINTS_PER_MINUTE;
        }
        return $durationQuiz * self::DURATION_QUIZ_MINUTES * self::QUIZ_POINTS_PER_MINUTE;
    }
}
