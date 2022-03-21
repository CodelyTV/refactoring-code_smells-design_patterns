import { GraduatedTieredPricing } from "../src/GraduatedTieredPricing";

describe("Graduated tiered pricing should", () => {
  test("return 299€ for 1 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(1);
  });
});
