package tv.codely.checkout;

public record Subscriptions(int volume) {
    public Subscriptions{
        if (volume < 1) {
            throw new IllegalArgumentException("You have to buy at least one subscription");
        }
    }
    public static Subscriptions by(int volume) {
        return new Subscriptions(volume);
    }
}
