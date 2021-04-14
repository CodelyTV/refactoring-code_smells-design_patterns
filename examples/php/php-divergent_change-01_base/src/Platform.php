<?php

declare(strict_types=1);

namespace CodelyTv\DivergentChange;

interface Platform
{
    public function findCourseSteps(string $courseId): string;
}
