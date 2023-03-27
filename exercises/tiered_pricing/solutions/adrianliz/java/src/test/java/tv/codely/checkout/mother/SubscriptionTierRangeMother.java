package tv.codely.checkout.mother;

import java.util.ArrayList;
import java.util.List;
import tv.codely.checkout.SubscriptionTierRange;

public final class SubscriptionTierRangeMother {

    public static SubscriptionTierRange first(final int numberOfSubscriptions) {
        return SubscriptionTierRange.first(numberOfSubscriptions);
    }

    public static SubscriptionTierRange last(final SubscriptionTierRange range) {
        return SubscriptionTierRange.last(range);
    }

    public static List<SubscriptionTierRange> randoms() {
        final var tierRanges = new ArrayList<SubscriptionTierRange>();
        final var numberOfTiers = IntegerMother.randomBetween(1, 6);
        final var minSubscriptionsInTier = 3;
        final var maxSubscriptionsInTier =
            IntegerMother.randomBetween(minSubscriptionsInTier + 1, 20);
        var currentTierRange = first(
            IntegerMother.randomBetween(minSubscriptionsInTier, maxSubscriptionsInTier));
        tierRanges.add(currentTierRange);

        for (int i = 0; i < numberOfTiers; i++) {
            if (i == numberOfTiers - 1) {
                tierRanges.add(last(currentTierRange));
                break;
            }

            final var numberOfSubscriptions =
                IntegerMother.randomBetween(minSubscriptionsInTier, maxSubscriptionsInTier);
            final var tierRange = SubscriptionTierRange.from(currentTierRange,
                numberOfSubscriptions);

            currentTierRange = tierRange;
            tierRanges.add(tierRange);
        }

        return tierRanges;
    }
}
