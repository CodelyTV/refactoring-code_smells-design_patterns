import each from "jest-each";

import GraduatedTieredPricing from "../src/GraduatedTieredPricing";
import NumberOfSubscriptionsNotAllowed from "../src/NumberOfSubscriptionsNotAllowed";

describe("Graduated tiered pricing should", () => {
  it("calculate the price for 0 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(() => pricing.priceFor(0)).toThrow(NumberOfSubscriptionsNotAllowed);
  });

  each([
    [1, 299],
    [2, 598],
    [3, 837],
    [11, 2729],
    [26, 5994],
    [50, 10770],
    [100, 18220],
  ]).it(
    "calculate the price for %i subscriptions",
    (subscriptions: number, expectedPrice: number) => {
      const pricing = new GraduatedTieredPricing();
      expect(pricing.priceFor(subscriptions)).toBe(expectedPrice);
    }
  );
});
