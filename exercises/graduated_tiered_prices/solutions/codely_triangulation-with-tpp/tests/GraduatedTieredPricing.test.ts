import { GraduatedTieredPricing } from "../src/GraduatedTieredPricing";

describe("Graduated tiered pricing should", () => {
  test("return 299€ for 1 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(1);

    expect(total).toBe(299);
  });

  test("return 598€ for 2 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(2);

    expect(total).toBe(598);
  });
});
