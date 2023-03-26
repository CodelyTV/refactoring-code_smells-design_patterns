package tv.codely.checkout;

import java.util.List;

public class TieredPricing {

    private final List<SubscriptionTier> subscriptionTiers;

    public TieredPricing(final List<SubscriptionTier> subscriptionTiers) {
        this.subscriptionTiers = subscriptionTiers;
    }

    public TieredPricing() {
        this(List.of(
            new SubscriptionTier(
                new SubscriptionTierRange(1, 2),
                new SubscriptionTierPrice(299)),
            new SubscriptionTier(
                new SubscriptionTierRange(3, 10),
                new SubscriptionTierPrice(239)),
            new SubscriptionTier(
                new SubscriptionTierRange(11, 25),
                new SubscriptionTierPrice(219)),
            new SubscriptionTier(
                new SubscriptionTierRange(26, 50),
                new SubscriptionTierPrice(199)),
            new SubscriptionTier(
                new SubscriptionTierRange(51, 100),
                new SubscriptionTierPrice(149))));
    }

    public double getTotalPrice(int subscriptions) {
        return subscriptionTiers.stream()
            .filter(subscriptionTier -> subscriptionTier.isInRange(subscriptions))
            .findFirst()
            .map(subscriptionTier -> subscriptionTier.getTotalPrice(subscriptions))
            .orElse(0D);
    }

    public double getBasePrice(int subscriptions) {
        return subscriptionTiers.stream()
            .filter(subscriptionTier -> subscriptionTier.isInRange(subscriptions))
            .findFirst()
            .map(SubscriptionTier::unitPrice)
            .orElse(0D);
    }
}
