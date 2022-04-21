package tv.codely.checkout;

public class TieredPricing {

    public static final int FIRST_RANGE_UNIT_PRICE = 299;
    public static final int FIRST_RANGE_LOWER_LIMIT = 1;
    public static final int FIRST_RANGE_UPPER_LIMIT = 2;

    public int calculateTotalPrice(int amount_subscriptions) {
        if (amount_subscriptions >= FIRST_RANGE_LOWER_LIMIT && amount_subscriptions<= FIRST_RANGE_UPPER_LIMIT) return amount_subscriptions * FIRST_RANGE_UNIT_PRICE;

        if (amount_subscriptions == 3) return 717;

        return 0;
    }
}
