package tv.codely.checkout;

public class TieredPricing {

    public int calculateTotalPrice(int amount_subscriptions) {
        return Tier.getTotalPrice(amount_subscriptions);
    }
}
