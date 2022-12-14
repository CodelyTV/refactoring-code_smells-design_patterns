package com.adrianlh.service;

public class TierPriceCalculatorService {

  public static final Integer TIER_TWO_MAX_UNITS = 10;
  private static final Integer TIER_ONE_MAX_UNITS = 2;
  private static final Integer TIER_ONE_PRICE = 299;
  private static final Integer TIER_TWO_PRICE = 239;
  public static final Integer TIER_THREE_PRICE = 219;


  public Integer calculateTieredPrice(final Integer numberOfLicenses) {
    final Integer totalPrice;
    if (numberOfLicenses <= 2) {
      totalPrice = TIER_ONE_PRICE * numberOfLicenses;
    } else if (numberOfLicenses <= 10) {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (numberOfLicenses
          - TIER_ONE_MAX_UNITS);
    } else {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (TIER_TWO_MAX_UNITS
          - TIER_ONE_MAX_UNITS) + TIER_THREE_PRICE * (numberOfLicenses - TIER_TWO_MAX_UNITS);
    }
    return totalPrice;
  }
}
