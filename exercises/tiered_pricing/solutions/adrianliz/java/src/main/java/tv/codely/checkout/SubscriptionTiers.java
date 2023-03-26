package tv.codely.checkout;

import java.util.HashSet;
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

        if (tiers.stream().noneMatch(SubscriptionTier::isFirst)) {
            throw new InvalidSubscriptionTiers("There must be a first subscription tier");
        }

        if (tiers.stream().noneMatch(SubscriptionTier::isLast)) {
            throw new InvalidSubscriptionTiers("There must be a last subscription tier");
        }

        if (tiers.size() == 1) {
            return;
        }

        final var validTiers = new HashSet<SubscriptionTier>();
        for (final SubscriptionTier tier : tiers) {
            if (tiers.stream()
                .anyMatch(
                    t -> !validTiers.contains(t) && !t.equals(tier) && !t.isAfter(tier))) {
                throw new InvalidSubscriptionTiers("All tiers must be after the previous one");
            }
            validTiers.add(tier);
        }
    }

    private SubscriptionTier findSuitableTier(int subscriptions) {
        return tiers.stream()
            .filter(tier -> tier.isInRange(subscriptions))
            .findFirst()
            .orElseThrow(() -> new InvalidSubscriptionTiers(
                "There is no subscription tier for " + subscriptions + " subscriptions"));
    }

    public double getTotalPrice(int subscriptions) {
        return findSuitableTier(subscriptions).getTotalPrice(subscriptions);
    }

    public double getBasePrice(int subscriptions) {
        return findSuitableTier(subscriptions).unitPrice();
    }
}
