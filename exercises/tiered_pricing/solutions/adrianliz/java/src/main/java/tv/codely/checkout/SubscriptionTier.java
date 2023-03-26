package tv.codely.checkout;

import java.util.Objects;

public final class SubscriptionTier {

    private final SubscriptionTierRange range;
    private final SubscriptionTierPrice price;

    public SubscriptionTier(
        final SubscriptionTierRange range,
        final SubscriptionTierPrice price) {

        this.range = range;
        this.price = price;
    }

    public boolean isFirst() {
        return range.isFirst();
    }

    public boolean isLast() {
        return range.isLast();
    }

    public boolean isAfter(final SubscriptionTier other) {
        return range.isAfter(other.range);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTier that = (SubscriptionTier) o;
        return Objects.equals(range, that.range) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(range, price);
    }
}
