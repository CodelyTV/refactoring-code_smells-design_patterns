package com.adrianlh.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TierPriceCalculatorServiceTest {

  final TierPriceCalculatorService service = new TierPriceCalculatorService();

  @Test
  void calculatePriceOneLicense() {
    final Integer numberOfLicenses = 1;
    final Integer total = service.calculateTieredPrice(numberOfLicenses);
    Assertions.assertThat(total).isEqualTo(299);

  }
}
