package tv.codely.checkout;

public class TieredPricing {

  private static final double UNIT_PRICE = 299.0;

  public double totalPrice(int subscriptions) {
    return subscriptions * UNIT_PRICE;
  }
}
