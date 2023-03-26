package tv.codely.checkout;

public final class PriceRange {

    private final int numberOfSubscriptionsFrom;
    private final int numberOfSubscriptionsTo;
    private final double unitPrice;

    public PriceRange(int numberOfSubscriptionsFrom, int numberOfSubscriptionsTo,
        double unitPrice) {
        this.numberOfSubscriptionsFrom = numberOfSubscriptionsFrom;
        this.numberOfSubscriptionsTo = numberOfSubscriptionsTo;
        this.unitPrice = unitPrice;
    }

    public PriceRange(final SubscriptionRange range,
        final SubscriptionPrice price) {
        this(range.numberOfSubscriptionsFrom(), range.numberOfSubscriptionsTo(),
            price.price());
    }

    public boolean isInRange(int numberOfSubscriptions) {
        return numberOfSubscriptions >= numberOfSubscriptionsFrom
            && numberOfSubscriptions <= numberOfSubscriptionsTo;
    }

    public double unitPrice() {
        return unitPrice;
    }

    public double getTotalPrice(int numberOfSubscriptions) {
        return unitPrice * numberOfSubscriptions;
    }
}
