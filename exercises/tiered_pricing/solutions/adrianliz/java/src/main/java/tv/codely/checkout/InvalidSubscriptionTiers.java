package tv.codely.checkout;

public final class InvalidSubscriptionTiers extends RuntimeException {

    public InvalidSubscriptionTiers(String message) {
        super(message);
    }
}
