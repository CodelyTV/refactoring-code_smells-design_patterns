<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Tests\Controller;

use CodelyTv\DivergentChange\Controller\CourseStepsGetController;
use CodelyTv\DivergentChange\Platform;
use PHPUnit\Framework\TestCase;

final class CourseStepsGetTest extends TestCase
{
    private Platform $platform;
    private CourseStepsGetController $courseStepGetController;

    public function setUp(): void
    {
        $this->platform = $this->createMock(Platform::class);
        $this->courseStepGetController = new CourseStepsGetController($this->platform);
    }

    /** @test */
    public function shouldReturnEmptyStepList(): void
    {
        $courseId = '8fe17ce6-1d33-4b6b-a27c-4e0d1f870a19';
        $emptyCsv = '';
        $this->givenPlatformReturnsCourseStepCsv($courseId, $emptyCsv);

        $results = $this->courseStepGetController->get($courseId);

        self::assertSame('[]', $results);
    }

    /** @test */
    public function shouldReturnExistingCourseSteps(): void
    {
        $courseId = '8fe17ce6-1d33-4b6b-a27c-4e0d1f870a19';
        $csv      = '"1","video","","13"
                     "2","quiz","5",""';
        $this->givenPlatformReturnsCourseStepCsv($courseId, $csv);

        $results = $this->courseStepGetController->get($courseId);

        $expected = '[{"id":"1","type":"video","duration":14.3,"points":1430},{"id":"2","type":"quiz","duration":2.5,"points":25}]';
        self::assertSame($expected, $results);
    }

    /** @test */
    public function shouldIgnoreStepsWithInvalidType(): void
    {
        $courseId = '8fe17ce6-1d33-4b6b-a27c-4e0d1f870a19';
        $csv      = '"1","survey","","13"';
        $this->givenPlatformReturnsCourseStepCsv($courseId, $csv);

        $results = $this->courseStepGetController->get($courseId);

        self::assertSame('[]', $results);
    }

    private function givenPlatformReturnsCourseStepCsv(string $courseId, string $csv): void
    {
        $this->platform
            ->method('findCourseSteps')
            ->with($courseId)
            ->willReturn($csv);
    }
}
