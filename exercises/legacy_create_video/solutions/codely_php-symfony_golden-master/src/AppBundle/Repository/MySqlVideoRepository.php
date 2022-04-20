<?php

declare(strict_types=1);

namespace AppBundle\Repository;

use Doctrine\DBAL\Connection;

class MySqlVideoRepository
{
    /**
     * @var Connection
     */
    private $connection;

    public function __construct(Connection $connection)
    {
        $this->connection = $connection;
    }

    public function save(string $title, $url, $courseId): string
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
        return $this->connection->lastInsertId();
    }
}