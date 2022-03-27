package tv.codely.checkout;

public class TieredPricing {

  private enum Tier {
    FIRST(299.0),
    SECOND(239.0),
    THIRD(219.0);

    final double unitPrice;

    Tier(double unitPrice) {
      this.unitPrice = unitPrice;
    }
  }

  public double totalPrice(int subscriptions) {
    return subscriptions * getTier(subscriptions).unitPrice;
  }

  private Tier getTier(int subscriptions) {
    if (subscriptions < 3) {
      return Tier.FIRST;
    }
    if (subscriptions < 11) {
      return Tier.SECOND;
    }
    return Tier.THIRD;
  }
}
