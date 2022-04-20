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
        if (strpos($title, "hexagonal")) {
            $title = str_replace("hexagonal", "Hexagonal", $title);
        }
        if (strpos($title, "solid")) {
            $title = str_replace("solid", "SOLID", $title);
        }
        if (strpos($title, "tdd")) {
            $title = str_replace("tdd", "TDD", $title);
        }
        return $title;
    }
}