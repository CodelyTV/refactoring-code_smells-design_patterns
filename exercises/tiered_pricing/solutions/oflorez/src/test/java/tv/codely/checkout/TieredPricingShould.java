package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private int retrieveSubscriptionGivenTier(Tier tier) {
        return IntStream.rangeClosed(tier.getLowerLimit(), tier.getUpperLimit()).findAny().getAsInt();
    }

    private int calculateTotalPriceExpected(int unitPrice, int subscription) {
        return unitPrice * subscription;
    }
}
