package tv.codely.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import tv.codely.checkout.mother.IntegerMother;
import tv.codely.checkout.mother.SubscriptionTierMother;

public class TieredPricingShould {

    private static List<SubscriptionTier> defaultSubscriptionTiers() {
        return List.of(
            new SubscriptionTier(
                new SubscriptionTierRange(1, 2),
                new SubscriptionTierPrice(299)),
            new SubscriptionTier(
                new SubscriptionTierRange(3, 10),
                new SubscriptionTierPrice(239)),
            new SubscriptionTier(
                new SubscriptionTierRange(11, 25),
                new SubscriptionTierPrice(219)),
            new SubscriptionTier(
                new SubscriptionTierRange(26, 50),
                new SubscriptionTierPrice(199)),
            new SubscriptionTier(
                new SubscriptionTierRange(51, 100),
                new SubscriptionTierPrice(149)));
    }

    @Test
    void unit_test_example() {
        assertTrue(true);
    }

    @Test
    void return_total_price_based_on_number_of_subscriptions() {
        final var subscriptionTiers = SubscriptionTierMother.randoms();
        final var tieredPricing = new TieredPricing(subscriptionTiers);
        final var numberOfSubscriptions = IntegerMother.random();
        final var expectedPrice =
            tieredPricing.getBasePrice(numberOfSubscriptions) * numberOfSubscriptions;

        final var totalPrice = tieredPricing.getTotalPrice(numberOfSubscriptions);

        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_1_subscription() {
        final var tieredPricing = new TieredPricing(defaultSubscriptionTiers());
        final var expectedPrice = 299;

        final var totalPrice = tieredPricing.getTotalPrice(1);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_3_subscriptions() {
        final var tieredPricing = new TieredPricing(defaultSubscriptionTiers());
        final var expectedPrice = 239 * 3;

        final var totalPrice = tieredPricing.getTotalPrice(3);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_11_subscriptions() {
        final var tieredPricing = new TieredPricing(defaultSubscriptionTiers());
        final var expectedPrice = 219 * 11;

        final var totalPrice = tieredPricing.getTotalPrice(11);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_26_subscriptions() {
        final var tieredPricing = new TieredPricing(defaultSubscriptionTiers());
        final var expectedPrice = 199 * 26;

        final var totalPrice = tieredPricing.getTotalPrice(26);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_51_subscriptions() {
        final var tieredPricing = new TieredPricing(defaultSubscriptionTiers());
        final var expectedPrice = 149 * 51;

        final var totalPrice = tieredPricing.getTotalPrice(51);
        assertEquals(expectedPrice, totalPrice);
    }
}
