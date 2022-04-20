<?php

declare(strict_types=1);

namespace AppBundle\Tests\Application;

use AppBundle\Application\VideoCreator;
use AppBundle\Repository\MySqlVideoRepository;
use PHPUnit\Framework\TestCase;

final class VideoCreatorTest extends TestCase
{
    /** @test */
    public function itShouldTransformFrontEndWord(): void
    {
        $repository = $this->createMock(MySqlVideoRepository::class);
        $videoCreator = new VideoCreator($repository);

        list($title) = $videoCreator->createVideo("Testing frontend", "url", 3);

        $this->assertEquals("Testing Front-end", $title);
    }
}
