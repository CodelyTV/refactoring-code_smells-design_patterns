package com.adrianlh.service;

public class TierPriceCalculatorService {

  private final Integer TIER_ONE_MAX_UNITS = 2;
  private final Integer TIER_ONE_PRICE = 299;
  private final Integer TIER_TWO_PRICE = 239;

  public Integer calculateTieredPrice(final Integer numberOfLicenses) {
    final Integer totalPrice;
    if (numberOfLicenses <= 2) {
      totalPrice = TIER_ONE_PRICE * numberOfLicenses;
    } else if (numberOfLicenses <= 10) {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (numberOfLicenses
          - TIER_ONE_MAX_UNITS);
    } else {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (numberOfLicenses
          - TIER_ONE_MAX_UNITS - 1) + 219 * (numberOfLicenses - 10);
    }
    return totalPrice;
  }
}
