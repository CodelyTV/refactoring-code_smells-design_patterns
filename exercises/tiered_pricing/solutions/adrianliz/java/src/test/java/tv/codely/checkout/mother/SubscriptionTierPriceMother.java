package tv.codely.checkout.mother;

import tv.codely.checkout.SubscriptionTierPrice;

public final class SubscriptionTierPriceMother {

    public static SubscriptionTierPrice create(final double value) {
        return new SubscriptionTierPrice(value);
    }

    public static SubscriptionTierPrice randomBetween(final int min, final int max) {
        return create(DoubleMother.randomBetween(min, max));
    }
}
