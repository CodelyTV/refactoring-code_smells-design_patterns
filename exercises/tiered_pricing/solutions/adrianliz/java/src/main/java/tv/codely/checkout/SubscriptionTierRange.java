package tv.codely.checkout;

public final class SubscriptionTierRange {

    private final int numberOfSubscriptionsFrom;
    private final int numberOfSubscriptionsTo;

    public SubscriptionTierRange(int numberOfSubscriptionsFrom, int numberOfSubscriptionsTo) {
        this.numberOfSubscriptionsFrom = numberOfSubscriptionsFrom;
        this.numberOfSubscriptionsTo = numberOfSubscriptionsTo;
    }

    public boolean isSuitableFor(int numberOfSubscriptions) {
        return numberOfSubscriptions >= numberOfSubscriptionsFrom
            && numberOfSubscriptions <= numberOfSubscriptionsTo;
    }
}
