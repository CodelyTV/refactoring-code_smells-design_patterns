import GraduatedTieredPricing from "../src/GraduatedTieredPricing";
import NumberOfSubscriptionsNotAllowed from "../src/NumberOfSubscriptionsNotAllowed";

describe("Graduated tiered pricing should", () => {
  it("calculate the price for 0 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(() => pricing.priceFor(0)).toThrow(NumberOfSubscriptionsNotAllowed);
  });

  it("calculate the price for 1 subscription", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(1)).toBe(299);
  });

  it("calculate the price for 2 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(2)).toBe(598);
  });

  it("calculate the price for 3 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(3)).toBe(837);
  });

  it("calculate the price for 11 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(11)).toBe(2729);
  });

  it("calculate the price for 26 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(26)).toBe(5994);
  });

  it("calculate the price for 50 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(50)).toBe(10770);
  });

  it("calculate the price for 100 subscriptions", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(100)).toBe(18220);
  });
});
