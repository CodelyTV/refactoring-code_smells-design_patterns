package tv.codely.checkout;

public final class SubscriptionPrice {

    private final double price;

    public SubscriptionPrice(double price) {
        this.price = price;
    }

    public double price() {
        return price;
    }
}
