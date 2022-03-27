package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TieredPricingShould {

  @Test
  void returnUnitPriceForOneSubscription() {
    var tieredPricing = new TieredPricing();

    double totalPrice = tieredPricing.totalPrice(1);

    assertThat(totalPrice).isEqualTo(299.0);
  }
}
