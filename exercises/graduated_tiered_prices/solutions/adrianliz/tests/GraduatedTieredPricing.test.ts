import each from "jest-each";

import GraduatedTier from "../src/GraduatedTier";
import GraduatedTieredPricing from "../src/GraduatedTieredPricing";
import NumberOfSubscriptionsNotAllowed from "../src/NumberOfSubscriptionsNotAllowed";
import Subscriptions from "../src/Subscriptions";

describe("Graduated tiered pricing should", () => {
  const defaultTiers = (): GraduatedTier[] => {
    return [
      new GraduatedTier(1, 2, 299),
      new GraduatedTier(3, 10, 239),
      new GraduatedTier(11, 25, 219),
      new GraduatedTier(26, 50, 199),
      new GraduatedTier(51, Number.MAX_SAFE_INTEGER, 149),
    ];
  };

  it("throw number of subscriptions not allowed for 0 subscriptions", () => {
    const tiers = defaultTiers();
    const pricing = new GraduatedTieredPricing(tiers);
    expect(() => pricing.priceFor(new Subscriptions(0))).toThrow(
      NumberOfSubscriptionsNotAllowed
    );
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
      const tiers = defaultTiers();
      const pricing = new GraduatedTieredPricing(tiers);
      expect(pricing.priceFor(new Subscriptions(subscriptions))).toBe(
        expectedPrice
      );
    }
  );
});
