<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Controller;

use CodelyTv\DivergentChange\Platform;

final class CourseStepsGetController
{
    const VIDEO_DURATION_PAUSES_MULTIPLIER  = 1.1;
    const QUIZ_TIME_PER_QUESTION_MULTIPLIER = 0.5;
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
            $stepDurationInMinutes = 0;
            $points   = 0;

            $videoDuration = $row[3];
            if ($type === 'video') {
                $stepDurationInMinutes = $videoDuration * self::VIDEO_DURATION_PAUSES_MULTIPLIER;
            }

            $quizTotalQuestions = $row[2];
            if ($type === 'quiz') {
                $stepDurationInMinutes = $quizTotalQuestions * self::QUIZ_TIME_PER_QUESTION_MULTIPLIER;
            }

            if ($type !== 'video' && $type !== 'quiz') {
                continue;
            }

            if ($type === 'video') {
                $points = $stepDurationInMinutes * 100;
            }

            if ($type === 'quiz') {
                $points = $quizTotalQuestions * self::QUIZ_TIME_PER_QUESTION_MULTIPLIER * 10;
            }

            $results .= json_encode(
                [
                    'id' => $row[0],
                    'type' => $row[1],
                    'duration' => $stepDurationInMinutes,
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
