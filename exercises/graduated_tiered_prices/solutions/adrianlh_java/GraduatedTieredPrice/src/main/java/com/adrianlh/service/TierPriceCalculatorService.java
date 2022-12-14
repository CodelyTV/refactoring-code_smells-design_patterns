package com.adrianlh.service;

public class TierPriceCalculatorService {

  public Integer calculateTieredPrice(final Integer numberOfLicenses) {
    if (numberOfLicenses <= 2) {
      return 299 * numberOfLicenses;
    } else {
      return 299 * 2 + 239 * (numberOfLicenses - 2);
    }
  }
}
