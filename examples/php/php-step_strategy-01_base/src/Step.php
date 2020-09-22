<?php

declare(strict_types=1);

namespace CodelyTv\StepStrategy;

final class Step
{
    private string   $title;
    public StepType $type;
    public ?int     $videoDurationInMinutes;
    public ?array   $quizQuestions;

    public function __construct(string $title, int $typeCode, ?int $videoDurationInMinutes, ?array $quizQuestions)
    {
        $this->title                  = $title;
        $this->type                   = StepType::fromPrimitive($typeCode, $videoDurationInMinutes, $quizQuestions);
        $this->videoDurationInMinutes = $videoDurationInMinutes;
        $this->quizQuestions          = $quizQuestions;
    }

    public function estimatedCompletionMinutes(): int
    {
        return $this->type->stepEstimatedCompletionMinutes($this);
    }
}
