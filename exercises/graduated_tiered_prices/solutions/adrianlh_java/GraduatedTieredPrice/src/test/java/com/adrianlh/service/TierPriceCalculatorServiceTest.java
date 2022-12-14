package com.adrianlh.service;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TierPriceCalculatorServiceTest {

  final TierPriceCalculatorService service = new TierPriceCalculatorService();

  private static Stream<Arguments> generateArgumentsForLicenses() {
    // This is used to give the case to our ParameterizedTest if
    // you want to add new case, just add the arguments
    return Stream.of(arguments(1, 299),
        arguments(2, 598),
        arguments(3, 837),
        arguments(11, 2729),
        arguments(26, 5994));
  }

  @ParameterizedTest(name = "Calculate the total price for {0} licenses")
  @MethodSource("generateArgumentsForLicenses")
  void calculatePriceOneLicense(final Integer numberOfLicenses, final Integer expectedTotal) {
    final Integer total = service.calculateTieredPrice(numberOfLicenses);
    Assertions.assertThat(total).isEqualTo(expectedTotal);

  }

}
