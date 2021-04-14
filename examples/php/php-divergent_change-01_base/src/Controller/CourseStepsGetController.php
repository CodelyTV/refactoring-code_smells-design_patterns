<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Controller;

use CodelyTv\DivergentChange\Platform;

final class CourseStepsGetController
{
    private const VIDEO_DURATION_PAUSES_MULTIPLIER  = 1.1;
    private const QUIZ_TIME_PER_QUESTION_MULTIPLIER = 0.5;
    private const STEP_TYPE_VIDEO                   = 'video';
    private const STEP_TYPE_QUIZ                    = 'quiz';
    private const VIDEO_POINTS_PER_MINUTE           = 100;
    private const QUIZ_POINTS_PER_MINUTE            = 10;
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

        $parsedCsv = $this->parseCsv($csv);

        $steps = [];
        foreach ($parsedCsv as $index => $row) {
            $stepId             = $row['stepId'];
            $type               = $row['type'];
            $quizTotalQuestions = $row['quizTotalQuestions'];
            $videoDuration      = $row['videoDuration'];

            $stepDurationInMinutes = 0;
            $points                = 0;

            if ($type === self::STEP_TYPE_VIDEO) {
                $stepDurationInMinutes = $videoDuration * self::VIDEO_DURATION_PAUSES_MULTIPLIER;
            }

            if ($type === self::STEP_TYPE_QUIZ) {
                $stepDurationInMinutes = $quizTotalQuestions * self::QUIZ_TIME_PER_QUESTION_MULTIPLIER;
            }

            if ($type === self::STEP_TYPE_VIDEO) {
                $points = $stepDurationInMinutes * self::VIDEO_POINTS_PER_MINUTE;
            }

            if ($type === self::STEP_TYPE_QUIZ) {
                $points = $stepDurationInMinutes * self::QUIZ_POINTS_PER_MINUTE;
            }

            $steps[] = [
                'id'       => $stepId,
                'type'     => $type,
                'duration' => $stepDurationInMinutes,
                'points'   => $points,
            ];
        }

        $results = '[';

        foreach ($steps as $index => $step) {
            $results .= json_encode($step, JSON_THROW_ON_ERROR);

            $hasMoreRows = $index !== count($steps) - 1;
            if ($hasMoreRows) {
                $results .= ',';
            }
        }

        $results .= ']';

        return $results;
    }

    private function parseCsv(string $csv): array
    {
        $csvLines = explode(PHP_EOL, $csv);

        $parsedCsv = [];
        foreach ($csvLines as $row) {
            $row = str_getcsv($row);

            [$stepId, $type, $quizTotalQuestions, $videoDuration] = $row;

            $isRecognizedStepType = $type !== self::STEP_TYPE_VIDEO && $type !== self::STEP_TYPE_QUIZ;
            if ($isRecognizedStepType) {
                continue;
            }

            $parsedCsv[] = [
                'stepId'             => $stepId,
                'type'               => $type,
                'quizTotalQuestions' => $quizTotalQuestions,
                'videoDuration'      => $videoDuration,
            ];
        }

        return $parsedCsv;
    }
}
