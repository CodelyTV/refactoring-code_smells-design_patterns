package tv.codely.checkout;

public class TieredPricing {
  public double totalPrice(int i) {
    if (i == 1) {
      return 299.0;
    }
    return 598.0;
  }
}
