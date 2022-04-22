package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TieredPricingShould {

    @Test
	void calculate_total_value_for_first_pricing_tier() {
        var pricing = new TieredPricing();
        var tier = Tier.FIRST;
        var subscription = retrieveSubscriptionGivenTier(tier);
        assertEquals(calculateTotalPriceExpected(tier.getUnitPrice(), subscription), pricing.calculateTotalPrice(subscription));
	}

    @Test
    void calculate_total_value_for_second_pricing_tier() {
        var pricing = new TieredPricing();
        var tier = Tier.SECOND;
        var subscription = retrieveSubscriptionGivenTier(tier);
        assertEquals(calculateTotalPriceExpected(tier.getUnitPrice(), subscription), pricing.calculateTotalPrice(subscription));
    }

    @Test
    void calculate_total_value_for_third_pricing_tier() {
        var pricing = new TieredPricing();
        var tier = Tier.THIRD;
        var subscription = retrieveSubscriptionGivenTier(tier);
        assertEquals(calculateTotalPriceExpected(tier.getUnitPrice(), subscription), pricing.calculateTotalPrice(subscription));
    }

    @Test
    void calculate_total_value_for_fourth_pricing_tier() {
        var pricing = new TieredPricing();
        var tier = Tier.FOURTH;
        var subscription = retrieveSubscriptionGivenTier(tier);
        assertEquals(calculateTotalPriceExpected(tier.getUnitPrice(), subscription), pricing.calculateTotalPrice(subscription));
    }

    @Test
    void calculate_total_value_for_fifth_pricing_tier() {
        var pricing = new TieredPricing();
        var tier = Tier.FIFTH;
        var subscription = retrieveSubscriptionGivenTier(tier);
        assertEquals(calculateTotalPriceExpected(tier.getUnitPrice(), subscription), pricing.calculateTotalPrice(subscription));
    }

    @Test
    void throws_illegal_argument_when_subscription_be_non_positive_value() {
        var pricing = new TieredPricing();
        var subscription = IntStream.rangeClosed(-100000, 0).findAny().getAsInt();
        assertThrows(IllegalArgumentException.class, () ->  pricing.calculateTotalPrice(subscription));
    }

    private int retrieveSubscriptionGivenTier(Tier tier) {
        return IntStream.rangeClosed(tier.getLowerLimit(), tier.getUpperLimit()).findAny().getAsInt();
    }

    private int calculateTotalPriceExpected(int unitPrice, int subscription) {
        return unitPrice * subscription;
    }
}
