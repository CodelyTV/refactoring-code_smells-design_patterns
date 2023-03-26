package tv.codely.checkout;

public final class SubscriptionTierNotFound extends RuntimeException {

    public SubscriptionTierNotFound(int numberOfSubscriptions) {
        super(String.format("Subscription tier not found for %d numberOfSubscriptions",
            numberOfSubscriptions));
    }
}
