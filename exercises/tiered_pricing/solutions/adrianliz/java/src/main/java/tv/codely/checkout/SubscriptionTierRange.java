package tv.codely.checkout;

import java.util.Objects;

// [from, to]
public final class SubscriptionTierRange {

    private final int numberOfSubscriptionsFrom;
    private final int numberOfSubscriptionsTo;

    private SubscriptionTierRange(int numberOfSubscriptionsFrom, int numberOfSubscriptionsTo) {
        this.numberOfSubscriptionsFrom = numberOfSubscriptionsFrom;
        this.numberOfSubscriptionsTo = numberOfSubscriptionsTo;
    }

    public static SubscriptionTierRange first(int numberOfSubscriptions) {
        validate(numberOfSubscriptions);
        return new SubscriptionTierRange(1, numberOfSubscriptions);
    }

    public static SubscriptionTierRange last(final SubscriptionTierRange range) {
        validate(range);
        return new SubscriptionTierRange(range.numberOfSubscriptionsTo + 1, Integer.MAX_VALUE);
    }

    public static SubscriptionTierRange from(
        final SubscriptionTierRange range,
        final int numberOfSubscriptions) {

        validate(range);
        validate(numberOfSubscriptions);

        final int numberOfSubscriptionsFrom = range.numberOfSubscriptionsTo + 1;
        final int numberOfSubscriptionsTo = numberOfSubscriptionsFrom + numberOfSubscriptions;
        return new SubscriptionTierRange(numberOfSubscriptionsFrom, numberOfSubscriptionsTo);
    }


    private static void validate(final int numberOfSubscriptions) {
        if (numberOfSubscriptions < 1) {
            throw new InvalidSubscriptionTierRange(
                "Number of subscriptions must be greater than 0");
        }
    }

    private static void validate(final SubscriptionTierRange range) {
        if (range == null) {
            throw new InvalidSubscriptionTierRange(
                "Cannot create a new subscription tier range from a null one");
        }

        if (range.isLast()) {
            throw new InvalidSubscriptionTierRange(
                "Cannot create a new subscription tier range after the last one");
        }
    }

    public boolean isFirst() {
        return numberOfSubscriptionsFrom == 1;
    }

    public boolean isLast() {
        return numberOfSubscriptionsTo == Integer.MAX_VALUE;
    }

    public boolean isAfter(final SubscriptionTierRange other) {
        return numberOfSubscriptionsFrom > other.numberOfSubscriptionsTo;
    }

    public boolean isSuitableFor(int numberOfSubscriptions) {
        return numberOfSubscriptions >= numberOfSubscriptionsFrom
            && numberOfSubscriptions <= numberOfSubscriptionsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTierRange that = (SubscriptionTierRange) o;
        return numberOfSubscriptionsFrom == that.numberOfSubscriptionsFrom
            && numberOfSubscriptionsTo == that.numberOfSubscriptionsTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfSubscriptionsFrom, numberOfSubscriptionsTo);
    }
}
