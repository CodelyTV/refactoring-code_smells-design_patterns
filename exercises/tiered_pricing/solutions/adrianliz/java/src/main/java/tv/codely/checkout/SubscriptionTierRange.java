package tv.codely.checkout;

public final class SubscriptionTierRange {

    private final int numberOfSubscriptionsFrom;
    private final int numberOfSubscriptionsTo;

    public SubscriptionTierRange(int numberOfSubscriptionsFrom, int numberOfSubscriptionsTo) {
        this.numberOfSubscriptionsFrom = numberOfSubscriptionsFrom;
        this.numberOfSubscriptionsTo = numberOfSubscriptionsTo;
    }

    public static SubscriptionTierRange last(int numberOfSubscriptionsFrom) {
        return new SubscriptionTierRange(numberOfSubscriptionsFrom, Integer.MAX_VALUE);
    }

    public boolean isSuitableFor(int numberOfSubscriptions) {
        return numberOfSubscriptions >= numberOfSubscriptionsFrom
            && numberOfSubscriptions <= numberOfSubscriptionsTo;
    }

    public boolean isLast() {
        return numberOfSubscriptionsTo == Integer.MAX_VALUE;
    }
}
