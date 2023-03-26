package tv.codely.checkout;

import java.util.Set;

public final class SubscriptionTiers {

    private final Set<SubscriptionTier> tiers;

    public SubscriptionTiers(final Set<SubscriptionTier> tiers) {
        validate(tiers);
        this.tiers = tiers;
    }

    private static void validate(final Set<SubscriptionTier> tiers) {
        if (tiers == null || tiers.isEmpty()) {
            throw new InvalidSubscriptionTiers("There must be at least one subscription tier");
        }

        if (tiers.stream().noneMatch(SubscriptionTier::isFirst)) {
            throw new InvalidSubscriptionTiers("There must be a first subscription tier");
        }

        if (tiers.stream().noneMatch(SubscriptionTier::isLast)) {
            throw new InvalidSubscriptionTiers("There must be a last subscription tier");
        }
    }

    private SubscriptionTier findSuitableTier(int numberOfSubscriptions) {
        return tiers.stream()
            .filter(tier -> tier.isInRange(numberOfSubscriptions))
            .findFirst()
            .orElseThrow(() -> new PriceNotFound(numberOfSubscriptions));
    }

    public double getTotalPrice(int numberOfSubscriptions) {
        return findSuitableTier(numberOfSubscriptions).getTotalPrice(numberOfSubscriptions);
    }

    public double getBasePrice(int numberOfSubscriptions) {
        return findSuitableTier(numberOfSubscriptions).unitPrice();
    }
}
