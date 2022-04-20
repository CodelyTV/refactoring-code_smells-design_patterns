<?php

declare(strict_types=1);

namespace AppBundle\Application;

use AppBundle\Repository\MySqlVideoRepository;

final class VideoCreator
{
    /** @var MySqlVideoRepository */
    private $repository;

    public function __construct(MySqlVideoRepository $repository)
    {
        $this->repository = $repository;
    }

    public function createVideo($title, $url, $courseId): array
    {
        $title = $this->sanitizeTitle($title);

        $videoId = $this->repository->save($title, $url, $courseId);

        return array($title, $videoId);
    }

    private function sanitizeTitle(string $title): string
    {
        $replacements = [
            "hexagonal" => "Hexagonal",
            "solid" => "SOLID",
            "tdd" => "TDD",
            "frontend" => "Front-end",
        ];

        foreach ($replacements as $search => $replace) {
            if (strpos($title, $search)) {
                $title = str_replace($search, $replace, $title);
            }
        }

        return $title;
    }
}