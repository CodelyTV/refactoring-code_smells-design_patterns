package tv.codely.checkout;

public final class InvalidSubscriptionTierPrice extends RuntimeException {

    public InvalidSubscriptionTierPrice(final String message) {
        super(message);
    }
}
