package tv.codely.checkout;

import java.util.List;

public final class SubscriptionTiers {

    private final List<SubscriptionTier> tiers;

    public SubscriptionTiers(List<SubscriptionTier> tiers) {
        validate(tiers);
        this.tiers = tiers;
    }

    private static void validate(final List<SubscriptionTier> tiers) {
        if (tiers == null || tiers.isEmpty()) {
            throw new InvalidSubscriptionTiers("There must be at least one subscription tier");
        }

        if (tiers.stream().noneMatch(SubscriptionTier::isLast)) {
            throw new IllegalArgumentException("There must be a last subscription tier");
        }
    }

    public List<SubscriptionTier> tiers() {
        return tiers;
    }
}
