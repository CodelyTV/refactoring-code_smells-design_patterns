<?php

declare(strict_types=1);

namespace AppBundle\Application;

use Doctrine\DBAL\Connection;

final class VideoCreator
{
    /** @var Connection */
    private $connection;

    public function __construct($connection)
    {
        $this->connection = $connection;
    }

    public function createVideo($title, $url, $courseId): array
    {
        $title = $this->sanitizeTitle($title);

        $videoId = $this->save($title, $url, $courseId);

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

    private function save(string $title, $url, $courseId): string
    {
        $sql = "INSERT INTO video (title, url, course_id) 
                VALUES (\"{$title}\",
                        \"{$url}\",
                        {$courseId}
                )";

        // Prepare doctrine statement
        $stmt = $this->connection->prepare($sql);
        $stmt->execute();

        // IMPORTANT: Obtaining the video id. Take care, it's done without another query :)
        $videoId = $this->connection->lastInsertId();
        return $videoId;
    }
}