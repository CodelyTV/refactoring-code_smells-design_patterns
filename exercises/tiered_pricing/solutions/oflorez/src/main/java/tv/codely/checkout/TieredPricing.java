package tv.codely.checkout;

public class TieredPricing {

    public int calculateTotalPrice(int amount_subscriptions) {

        if (amount_subscriptions <= 0) throw new IllegalArgumentException();

        return Tier.getTotalPrice(amount_subscriptions);
    }
}
