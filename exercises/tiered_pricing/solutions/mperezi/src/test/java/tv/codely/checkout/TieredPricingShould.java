package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TieredPricingShould {

  @Test
  void returnFirstTierUnitPriceForOneSubscription() {
    var tieredPricing = new TieredPricing();

    double totalPrice = tieredPricing.totalPrice(1);

    assertThat(totalPrice).isEqualTo(299.0);
  }

  @Test
  void returnDoubleTheFirstTierUnitPriceForTwoSubscriptions() {
    var tieredPricing = new TieredPricing();

    double totalPrice = tieredPricing.totalPrice(2);

    assertThat(totalPrice).isEqualTo(598.0);
  }

  @Test
  void returnTripleTheSecondTierUnitPriceForThreeSubscriptions() {
    var tieredPricing = new TieredPricing();

    double totalPrice = tieredPricing.totalPrice(3);

    assertThat(totalPrice).isEqualTo(717.0);
  }
}
