package tv.codely.checkout;

public final class PriceNotFound extends RuntimeException {

    public PriceNotFound(int subscriptions) {
        super(String.format("Price not found for %d subscriptions", subscriptions));
    }
}
