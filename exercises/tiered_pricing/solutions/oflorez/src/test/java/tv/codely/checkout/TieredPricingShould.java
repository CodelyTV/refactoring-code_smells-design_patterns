package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TieredPricingShould {

    @Test
	void return_total_price_299_for_1_subscription() {
        var pricing = new TieredPricing();
        assertEquals(299, pricing.calculateTotalPrice(1));
	}
}
