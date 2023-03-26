package tv.codely.checkout.mother;

import java.util.ArrayList;
import java.util.List;
import tv.codely.checkout.SubscriptionTierRange;

public final class SubscriptionTierRangeMother {

    public static SubscriptionTierRange create(
        final int numberOfSubscriptionsFrom,
        final int numberOfSubscriptionsTo) {

        return new SubscriptionTierRange(numberOfSubscriptionsFrom, numberOfSubscriptionsTo);
    }

    public static SubscriptionTierRange last(final int numberOfSubscriptionsFrom) {
        return SubscriptionTierRange.last(numberOfSubscriptionsFrom);
    }

    public static List<SubscriptionTierRange> randoms() {
        final var subscriptionTiers = new ArrayList<SubscriptionTierRange>();
        final var numberOfTiers = IntegerMother.randomBetween(1, 6);
        final var minSubscriptionsInTier = 3;
        final var maxSubscriptionsInTier =
            IntegerMother.randomBetween(minSubscriptionsInTier + 1, 20);

        var lastNumberOfSubscriptionsTo = 0;

        for (int i = 0; i < numberOfTiers; i++) {
            if (i == numberOfTiers - 1) {
                subscriptionTiers.add(last(lastNumberOfSubscriptionsTo + 1));
                break;
            }

            final var numberOfSubscriptionsFrom = lastNumberOfSubscriptionsTo + 1;
            final var numberOfSubscriptionsTo =
                IntegerMother.randomBetween(
                    numberOfSubscriptionsFrom + 1,
                    maxSubscriptionsInTier * (i + 1));

            lastNumberOfSubscriptionsTo = numberOfSubscriptionsTo;

            subscriptionTiers.add(create(numberOfSubscriptionsFrom, numberOfSubscriptionsTo));
        }

        return subscriptionTiers;
    }
}
