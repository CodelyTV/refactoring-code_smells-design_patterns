package tv.codely.checkout;

import java.util.Arrays;

public class TieredPricing {

  private enum Tier {
    FIRST(299.0, 1, 2),
    SECOND(239.0, 3, 10),
    THIRD(219.0, 11, 25),
    FOURTH(199.0, 26, 50),
    LAST(149.0, 51);

    final double unitPrice;
    final int startRange;
    final int endRange;

    Tier(double unitPrice, int startRange) {
      this(unitPrice, startRange, -1);
    }

    Tier(double unitPrice, int startRange, int endRange) {
      this.unitPrice = unitPrice;
      this.startRange = startRange;
      this.endRange = endRange;
    }

    static Tier of(int subscriptions) {
      return Arrays.stream(values())
                   .filter(tier -> subscriptions >= tier.startRange && subscriptions <= tier.endRange)
                   .findFirst()
                   .orElse(LAST);
    }
  }

  public double totalPrice(int subscriptions) {
    return subscriptions * Tier.of(subscriptions).unitPrice;
  }
}
