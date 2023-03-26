package tv.codely.checkout;

public final class SubscriptionTier {

    private final SubscriptionTierRange range;
    private final SubscriptionTierPrice price;

    public SubscriptionTier(
        final SubscriptionTierRange range,
        final SubscriptionTierPrice price) {

        this.range = range;
        this.price = price;
    }

    public boolean isInRange(int numberOfSubscriptions) {
        return this.range.isSuitableFor(numberOfSubscriptions);
    }

    public double unitPrice() {
        return price.unitPrice();
    }

    public double getTotalPrice(int numberOfSubscriptions) {
        return unitPrice() * numberOfSubscriptions;
    }
}
