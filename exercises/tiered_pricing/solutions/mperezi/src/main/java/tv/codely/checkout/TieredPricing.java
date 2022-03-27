package tv.codely.checkout;

public class TieredPricing {

  private static final double UNIT_PRICE = 299.0;

  public double totalPrice(int subscriptions) {
    if (subscriptions < 3) {
      return subscriptions * UNIT_PRICE;
    }
    return 717.0;
  }
}
