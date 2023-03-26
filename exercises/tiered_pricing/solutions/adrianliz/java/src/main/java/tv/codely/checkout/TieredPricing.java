package tv.codely.checkout;

import java.util.List;

public class TieredPricing {
    
    private final SubscriptionTiers tiers;

    public TieredPricing(final SubscriptionTiers subscriptionTiers) {
        this.tiers = subscriptionTiers;
    }

    public TieredPricing(final List<SubscriptionTier> subscriptionTiers) {
        this(new SubscriptionTiers(subscriptionTiers));
    }

    public double getTotalPrice(int subscriptions) {
        return tiers.getTotalPrice(subscriptions);
    }

    public double getBasePrice(int subscriptions) {
        return tiers.getBasePrice(subscriptions);
    }
}
