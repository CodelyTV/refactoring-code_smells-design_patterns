package tv.codely.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TieredPricingShould {

    private TieredPricing pricing;

    @BeforeEach
    void setUp() {
        pricing = new TieredPricing(new VolumePricingList(new TreeMap<>() {{
            put(1, Price.of(299, "€"));
            put(3, Price.of(239, "€"));
            put(11, Price.of(219, "€"));
            put(26, Price.of(199, "€"));
            put(51, Price.of(149, "€"));
        }}));
    }

    @Test
    void calculate_total_price_for_tier_one_subscriptions() {
        Subscriptions subscriptions = TieredSubscriptionsExamples.tierOne();
        Price total = pricing.calculateFor(subscriptions);
        Price expected = Price.of(299 * subscriptions.volume(), "€");
        assertEquals(total, expected);
    }

    @Test
    void calculate_total_price_for_tier_two_subscriptions() {
        Subscriptions subscriptions = TieredSubscriptionsExamples.tierTwo();
        Price total = pricing.calculateFor(subscriptions);
        Price expected = Price.of(239 * subscriptions.volume(), "€");
        assertEquals(total, expected);
    }

    @Test
    public void calculate_total_price_for_tier_three_subscriptions() {
        Subscriptions subscriptions = TieredSubscriptionsExamples.tierThree();
        Price total = pricing.calculateFor(subscriptions);
        Price expected = Price.of(219 * subscriptions.volume(), "€");
        assertEquals(total, expected);
    }

    @Test
    public void calculate_total_price_for_tier_four_subscriptions() {
        Subscriptions subscriptions = TieredSubscriptionsExamples.tierFour();
        Price total = pricing.calculateFor(subscriptions);
        Price expected = Price.of(199 * subscriptions.volume(), "€");
        assertEquals(total, expected);
    }

    @Test
    public void calculate_total_price_for_tier_five_subscriptions() {
        Subscriptions subscriptions = TieredSubscriptionsExamples.tierFive();
        Price total = pricing.calculateFor(subscriptions);
        Price expected = Price.of(149 * subscriptions.volume(), "€");
        assertEquals(total, expected);
    }
}
