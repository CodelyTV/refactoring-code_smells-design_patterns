<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange\Tests\Controller;

use CodelyTv\DivergentChange\Controller\CourseStepsGetController;
use CodelyTv\DivergentChange\Platform;
use PHPUnit\Framework\TestCase;

final class CourseStepsGetTest extends TestCase
{
    /** @test */
    public function shouldReturnEmptyStepList(): void
    {
        $platform = $this->createMock(Platform::class);
        $platform
            ->method('findCourseSteps')
            ->willReturn([]);

        $sut = new CourseStepsGetController($platform);

        $results = $sut->get('73D74817-CC25-477D-BF3E-36130087293F');

        self::assertSame('[]', $results);
    }

    /** @test */
    public function shouldReturnExistingCourseSteps(): void
    {
        $platform = $this->createMock(Platform::class);
        $platform
            ->method('findCourseSteps')
            ->with('73D74817-CC25-477D-BF3E-36130087293F')
            ->willReturn([
                [
                    'id' => 'uuid',
                    'type' => 'video',
                    'questions' => null,
                    'duration' => 13
                ],
                [
                    'id' => 'uuid',
                    'type' => 'quiz',
                    'questions' => 5,
                    'duration' => null
                ],
            ]);

        $sut = new CourseStepsGetController($platform);

        $results = $sut->get('73D74817-CC25-477D-BF3E-36130087293F');

        $expected = '[{"id":"uuid","type":"video","duration":14.3,"points":1430},{"id":"uuid","type":"quiz","duration":2.5,"points":25}]';
        self::assertSame($expected, $results);
    }

    /** @test */
    public function shouldIgnoreStepsWithInvalidType(): void
    {
        $platform = $this->createMock(Platform::class);
        $platform
            ->method('findCourseSteps')
            ->with('73D74817-CC25-477D-BF3E-36130087293F')
            ->willReturn([
                [
                    'id' => 'uuid',
                    'type' => 'survey',
                    'questions' => null,
                    'duration' => 13
                ]
            ]);

        $sut = new CourseStepsGetController($platform);

        $results = $sut->get('73D74817-CC25-477D-BF3E-36130087293F');

        self::assertSame('[]', $results);
    }
}
