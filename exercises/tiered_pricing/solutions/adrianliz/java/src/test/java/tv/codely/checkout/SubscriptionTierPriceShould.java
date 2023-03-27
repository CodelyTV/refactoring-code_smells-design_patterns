package tv.codely.checkout;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public final class SubscriptionTierPriceShould {

    @Test
    void throw_invalid_subscription_tier_price_if_price_is_less_than_1() {
        assertThrows(InvalidSubscriptionTierPrice.class, () -> new SubscriptionTierPrice(0));
    }
}
