package tv.codely.checkout;

import java.util.Set;

public class TieredPricing {

    private final SubscriptionTiers tiers;

    public TieredPricing(final SubscriptionTiers subscriptionTiers) {
        this.tiers = subscriptionTiers;
    }

    public TieredPricing(final Set<SubscriptionTier> subscriptionTiers) {
        this(new SubscriptionTiers(subscriptionTiers));
    }

    public double getTotalPrice(int numberOfSubscriptions) {
        return tiers.getTotalPrice(numberOfSubscriptions);
    }

    public double getBasePrice(int numberOfSubscriptions) {
        return tiers.getBasePrice(numberOfSubscriptions);
    }
}
