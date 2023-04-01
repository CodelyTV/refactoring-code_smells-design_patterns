import each from "jest-each";

import GraduatedTier from "../src/GraduatedTier";
import GraduatedTieredPricing from "../src/GraduatedTieredPricing";
import NumberOfSubscriptionsNotAllowed from "../src/NumberOfSubscriptionsNotAllowed";
import Subscriptions from "../src/Subscriptions";

describe("Graduated tiered pricing should", () => {
  const defaultTiers = (): GraduatedTier[] => {
    const firstTier = GraduatedTier.firstTier(2, 299);
    const secondTier = GraduatedTier.fromTier(firstTier, 8, 239);
    const thirdTier = GraduatedTier.fromTier(secondTier, 15, 219);
    const fourthTier = GraduatedTier.fromTier(thirdTier, 25, 199);
    const lastTier = GraduatedTier.lastTier(fourthTier, 149);
    return [firstTier, secondTier, thirdTier, fourthTier, lastTier];
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
