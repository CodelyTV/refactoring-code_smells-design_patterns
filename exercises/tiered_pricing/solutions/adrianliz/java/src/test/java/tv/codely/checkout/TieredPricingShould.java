package tv.codely.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TieredPricingShould {

    @Test
    void unit_test_example() {
        assertTrue(true);
    }

    @Test
    void return_total_price_based_on_number_of_subscriptions() {
        final var priceRanges =
            List.of(
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
        final var tieredPricing = new TieredPricing(priceRanges);
        final var expectedPrice = priceRanges.get(1).unitPrice() * 3;

        final var totalPrice = tieredPricing.getTotalPrice(3);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_1_subscription() {
        final var tieredPricing = new TieredPricing();
        final var expectedPrice = 299;

        final var totalPrice = tieredPricing.getTotalPrice(1);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_3_subscriptions() {
        final var tieredPricing = new TieredPricing();
        final var expectedPrice = 239 * 3;

        final var totalPrice = tieredPricing.getTotalPrice(3);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_11_subscriptions() {
        final var tieredPricing = new TieredPricing();
        final var expectedPrice = 219 * 11;

        final var totalPrice = tieredPricing.getTotalPrice(11);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_26_subscriptions() {
        final var tieredPricing = new TieredPricing();
        final var expectedPrice = 199 * 26;

        final var totalPrice = tieredPricing.getTotalPrice(26);
        assertEquals(expectedPrice, totalPrice);
    }

    @Test
    void return_total_price_for_51_subscriptions() {
        final var tieredPricing = new TieredPricing();
        final var expectedPrice = 149 * 51;

        final var totalPrice = tieredPricing.getTotalPrice(51);
        assertEquals(expectedPrice, totalPrice);
    }
}
