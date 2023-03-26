package tv.codely.checkout;

public final class SubscriptionTierPrice {

    private final double value;

    public SubscriptionTierPrice(double value) {
        this.value = value;
    }

    public double unitPrice() {
        return value;
    }
}
