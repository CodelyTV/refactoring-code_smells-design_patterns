package tv.codely.checkout.mother;

import tv.codely.checkout.SubscriptionTierPrice;

public final class SubscriptionTierPriceMother {

    public static SubscriptionTierPrice create(final double value) {
        return new SubscriptionTierPrice(value);
    }

    public static SubscriptionTierPrice random() {
        return create(DoubleMother.randomBetween(100, 300));
    }
}
