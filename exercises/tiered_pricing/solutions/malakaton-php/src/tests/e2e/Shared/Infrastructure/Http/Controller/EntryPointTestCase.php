<?php

declare(strict_types=1);

namespace App\Tests\e2e\Shared\Infrastructure\Http\Controller;

use Symfony\Bundle\FrameworkBundle\KernelBrowser;
use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;
use Symfony\Component\Validator\Validation;
use Symfony\Component\Validator\Constraints as Assert;

abstract class EntryPointTestCase extends WebTestCase
{
    protected KernelBrowser $client;

    public function setUp(): void
    {
        parent::setUp();

        $this->client = static::createClient();
    }

    protected function assertJsonStructure(array $content): void
    {
        $constraint = new Assert\Collection(
            [
                'data' => new Assert\Type('array'),
                'meta' => new Assert\Collection([
                    'success'   => new Assert\Type('boolean'),
                    'message'   => new Assert\Type('string'),
                    'errors'    => new Assert\Type('array'),
                ])
            ]
        );

        $validationErrors = Validation::createValidator()->validate($content, $constraint);

        self::assertEquals(0, $validationErrors->count());
    }
}
