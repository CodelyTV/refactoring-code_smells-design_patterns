package tv.codely.checkout;

public class TieredPricing {

    public static final int FIRST_RANGE_UNIT_PRICE = 299;
    public static final int FIRST_RANGE_LOWER_LIMIT = 1;
    public static final int FIRST_RANGE_UPPER_LIMIT = 2;

    public static final int SECOND_RANGE_UNIT_PRICE = 239;
    public static final int SECOND_RANGE_LOWER_LIMIT = 3;
    public static final int SECOND_RANGE_UPPER_LIMIT = 10;

    public int calculateTotalPrice(int amount_subscriptions) {
        if (amount_subscriptions >= FIRST_RANGE_LOWER_LIMIT && amount_subscriptions<= FIRST_RANGE_UPPER_LIMIT) return amount_subscriptions * FIRST_RANGE_UNIT_PRICE;

        if (amount_subscriptions >= SECOND_RANGE_LOWER_LIMIT && amount_subscriptions<= SECOND_RANGE_UPPER_LIMIT) return amount_subscriptions * SECOND_RANGE_UNIT_PRICE;

        return 0;
    }
}
