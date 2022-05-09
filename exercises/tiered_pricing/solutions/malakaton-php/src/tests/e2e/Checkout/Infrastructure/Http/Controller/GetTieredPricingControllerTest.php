<?php

namespace App\Tests\e2e\Checkout\Infrastructure\Http\Controller;

use App\Tests\e2e\Shared\Infrastructure\Http\Controller\EntryPointTestCase;
use Symfony\Component\HttpFoundation\Response;

class GetTieredPricingControllerTest  extends EntryPointTestCase
{
    /**
     * @test
     */
    public function get_tiered_pricing_second_range_works(): void
    {
        $this->client->request(
            'GET',
            "/checkout/total?subscriptions=5",
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $response = json_decode(
            $this->client->getResponse()->getContent(),
            true,
            512,
            JSON_THROW_ON_ERROR
        );

        $this->assertJsonStructure($response);

        self::assertEquals(Response::HTTP_OK, $this->client->getResponse()->getStatusCode());

        self::assertEquals(1195, $response['data']['total_price']);
    }
}
