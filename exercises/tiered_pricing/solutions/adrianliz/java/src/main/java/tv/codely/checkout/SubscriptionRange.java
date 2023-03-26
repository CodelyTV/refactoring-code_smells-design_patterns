package tv.codely.checkout;

public final class SubscriptionRange {

    private final int numberOfSubscriptionsFrom;
    private final int numberOfSubscriptionsTo;

    public SubscriptionRange(int numberOfSubscriptionsFrom, int numberOfSubscriptionsTo) {
        this.numberOfSubscriptionsFrom = numberOfSubscriptionsFrom;
        this.numberOfSubscriptionsTo = numberOfSubscriptionsTo;
    }

    public boolean isSuitableFor(int numberOfSubscriptions) {
        return numberOfSubscriptions >= numberOfSubscriptionsFrom
            && numberOfSubscriptions <= numberOfSubscriptionsTo;
    }

    public int numberOfSubscriptionsFrom() {
        return numberOfSubscriptionsFrom;
    }

    public int numberOfSubscriptionsTo() {
        return numberOfSubscriptionsTo;
    }
}
