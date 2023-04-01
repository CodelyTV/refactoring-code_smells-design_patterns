import GraduatedTieredPricing from "../src/GraduatedTieredPricing";

describe("Graduated tiered pricing should", () => {
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
});

test("test framework working", async () => {
  expect(true).toBe(true);
});
