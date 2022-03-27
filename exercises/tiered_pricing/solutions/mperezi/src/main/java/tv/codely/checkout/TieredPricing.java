package tv.codely.checkout;

public class TieredPricing {

  private static final double FIRST_TIER_UNIT_PRICE = 299.0;
  private static final double SECOND_TIER_UNIT_PRICE = 239.0;
  public static final double THIRD_TIER_UNIT_PRICE = 219.0;

  public double totalPrice(int subscriptions) {
    if (subscriptions < 3) {
      return subscriptions * FIRST_TIER_UNIT_PRICE;
    }
    if (subscriptions < 11) {
      return subscriptions * SECOND_TIER_UNIT_PRICE;
    }
    return subscriptions * THIRD_TIER_UNIT_PRICE;
  }
}
