<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private string   $title;
    private StepType $type;

    public function __construct(string $title, int $typeCode, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        $this->title = $title;
        $this->type  = StepType::fromPrimitive($typeCode, $videoDurationInMinutes, $quizQuestions);
    }

    public function estimatedCompletionMinutes(): int
    {
        return $this->type->estimatedCompletionMinutes();
    }
}
