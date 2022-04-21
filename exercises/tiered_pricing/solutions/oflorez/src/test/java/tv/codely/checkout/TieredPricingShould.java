package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tv.codely.checkout.TieredPricing.*;

public class TieredPricingShould {

    @Test
	void calculate_total_value_for_first_pricing_range() {
        var pricing = new TieredPricing();
        var subscription = retrieveSubscriptionGivenRange(FIRST_RANGE_LOWER_LIMIT, FIRST_RANGE_UPPER_LIMIT);
        assertEquals(calculateTotalPriceExpected(FIRST_RANGE_UNIT_PRICE, subscription), pricing.calculateTotalPrice(subscription));
	}

    @Test
    void calculate_total_value_for_second_pricing_range() {
        var pricing = new TieredPricing();
        var subscription = retrieveSubscriptionGivenRange(SECOND_RANGE_LOWER_LIMIT,SECOND_RANGE_UPPER_LIMIT);
        assertEquals(calculateTotalPriceExpected(SECOND_RANGE_UNIT_PRICE, subscription), pricing.calculateTotalPrice(subscription));
    }

    @Test
    void calculate_total_value_for_third_pricing_range() {
        var pricing = new TieredPricing();
        var subscription = retrieveSubscriptionGivenRange(11,25);
        assertEquals(calculateTotalPriceExpected(219, subscription), pricing.calculateTotalPrice(subscription));
    }

    private int retrieveSubscriptionGivenRange(int lowerLimit, int upperLimit) {
        return IntStream.rangeClosed(lowerLimit, upperLimit).findAny().getAsInt();
    }

    private int calculateTotalPriceExpected(int unitPrice, int subscription) {
        return unitPrice * subscription;
    }
}
