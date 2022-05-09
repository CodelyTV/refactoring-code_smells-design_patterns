<?php

namespace App\Tests\Unit\Checkout\Domain;

use App\Checkout\Domain\TieredPricing;
use App\Tests\Unit\Shared\Infrastructure\PhpUnit\UnitTestCase;
use Faker\Factory;
use Faker\Generator;

class TieredPricingTest extends UnitTestCase
{
    protected Generator $faker;

    protected function setUp(): void
    {
        $this->faker = Factory::create();
    }

    /**
     * @test
     */
    public function it_should_get_price_from_first_range(): void
    {
        $tieredPricing = new TieredPricing($this->faker->numberBetween(1, 2));

        self::assertEquals(299, $tieredPricing->price());
    }

    /**
     * @test
     */
    public function it_should_get_price_from_second_range(): void
    {
        $tieredPricing = new TieredPricing($this->faker->numberBetween(3, 10));

        self::assertEquals(239, $tieredPricing->price());
    }

    /**
     * @test
     */
    public function it_should_get_price_from_third_range(): void
    {
        $tieredPricing = new TieredPricing($this->faker->numberBetween(11, 25));

        self::assertEquals(219, $tieredPricing->price());
    }

    /**
     * @test
     */
    public function it_should_get_price_from_fourth_range(): void
    {
        $tieredPricing = new TieredPricing($this->faker->numberBetween(26, 50));

        self::assertEquals(199, $tieredPricing->price());
    }

    /**
     * @test
     */
    public function it_should_get_price_from_last_range(): void
    {
        $tieredPricing = new TieredPricing($this->faker->numberBetween(51, 100));

        self::assertEquals(149, $tieredPricing->price());
    }

    /**
     * @test
     */
    public function it_should_calculate_tiered_pricing_first_range(): void
    {
        $subscriptions = $this->faker->numberBetween(1, 2);

        $tieredPricing = new TieredPricing($subscriptions);

        self::assertEquals($subscriptions * $tieredPricing->price(), $tieredPricing->total());
    }

    /**
     * @test
     */
    public function it_should_calculate_tiered_pricing_second_range(): void
    {
        $subscriptions = $this->faker->numberBetween(3, 10);

        $tieredPricing = new TieredPricing($subscriptions);

        self::assertEquals($subscriptions * $tieredPricing->price(), $tieredPricing->total());
    }

    /**
     * @test
     */
    public function it_should_calculate_tiered_pricing_third_range(): void
    {
        $subscriptions = $this->faker->numberBetween(11, 25);

        $tieredPricing = new TieredPricing($subscriptions);

        self::assertEquals($subscriptions * $tieredPricing->price(), $tieredPricing->total());
    }

    /**
     * @test
     */
    public function it_should_calculate_tiered_pricing_fourth_range(): void
    {
        $subscriptions = $this->faker->numberBetween(26, 50);

        $tieredPricing = new TieredPricing($subscriptions);

        self::assertEquals($subscriptions * $tieredPricing->price(), $tieredPricing->total());
    }

    /**
     * @test
     */
    public function it_should_calculate_tiered_pricing_last_range(): void
    {
        $subscriptions = $this->faker->numberBetween(51, 100);

        $tieredPricing = new TieredPricing($subscriptions);

        self::assertEquals($subscriptions * $tieredPricing->price(), $tieredPricing->total());
    }
}
