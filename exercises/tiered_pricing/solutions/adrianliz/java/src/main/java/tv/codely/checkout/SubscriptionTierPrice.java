package tv.codely.checkout;

import java.util.Objects;

public final class SubscriptionTierPrice {

    private final double value;

    public SubscriptionTierPrice(double value) {
        this.value = value;
    }

    public double unitPrice() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTierPrice that = (SubscriptionTierPrice) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
