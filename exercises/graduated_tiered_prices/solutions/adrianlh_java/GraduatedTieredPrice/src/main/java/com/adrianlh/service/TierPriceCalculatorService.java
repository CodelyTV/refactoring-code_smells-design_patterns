package com.adrianlh.service;

public class TierPriceCalculatorService {

  private static final Integer TIER_ONE_MAX_UNITS = 2;
  public static final Integer TIER_TWO_MAX_UNITS = 10;
  public static final Integer TIER_THREE_MAX_UNITS = 25;
  private static final Integer TIER_ONE_PRICE = 299;
  private static final Integer TIER_TWO_PRICE = 239;
  public static final Integer TIER_THREE_PRICE = 219;
  public static final Integer TIER_FOUR_PRICE = 199;


  public Integer calculateTieredPrice(final Integer numberOfLicenses) {
    final Integer totalPrice;
    if (numberOfLicenses <= 2) {
      totalPrice = TIER_ONE_PRICE * numberOfLicenses;
    } else if (numberOfLicenses <= 10) {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (numberOfLicenses
          - TIER_ONE_MAX_UNITS);
    } else if (numberOfLicenses <= 25) {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (TIER_TWO_MAX_UNITS
          - TIER_ONE_MAX_UNITS) + TIER_THREE_PRICE * (numberOfLicenses - TIER_TWO_MAX_UNITS);
    } else {
      totalPrice = TIER_ONE_PRICE * TIER_ONE_MAX_UNITS + TIER_TWO_PRICE * (TIER_TWO_MAX_UNITS
          - TIER_ONE_MAX_UNITS) + TIER_THREE_PRICE * (TIER_THREE_MAX_UNITS - TIER_TWO_MAX_UNITS)
          + TIER_FOUR_PRICE * (numberOfLicenses - TIER_THREE_MAX_UNITS);
    }
    return totalPrice;
  }
}
