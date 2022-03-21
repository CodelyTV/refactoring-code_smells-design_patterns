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

  test("return 837€ for 3 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(3);

    expect(total).toBe(837);
  });

  test("return 1076€ for 4 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(4);

    expect(total).toBe(1076);
  });
});
