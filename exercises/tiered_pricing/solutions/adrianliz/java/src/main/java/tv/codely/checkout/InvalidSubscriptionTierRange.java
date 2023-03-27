package tv.codely.checkout;

public final class InvalidSubscriptionTierRange extends RuntimeException {

    public InvalidSubscriptionTierRange(final String message) {
        super(message);
    }
}
