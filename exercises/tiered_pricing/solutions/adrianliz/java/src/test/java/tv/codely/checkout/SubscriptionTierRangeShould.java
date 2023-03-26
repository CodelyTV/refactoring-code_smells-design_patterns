package tv.codely.checkout;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public final class SubscriptionTierRangeShould {

    @Test
    void throw_invalid_subscription_tier_range_if_number_of_subscriptions_is_less_than_1() {
        assertThrows(InvalidSubscriptionTierRange.class, () -> SubscriptionTierRange.first(0));
    }

    @Test
    void throw_invalid_subscription_tier_range_if_previous_range_does_not_exist() {
        assertThrows(InvalidSubscriptionTierRange.class, () -> SubscriptionTierRange.last(null));
    }

}
