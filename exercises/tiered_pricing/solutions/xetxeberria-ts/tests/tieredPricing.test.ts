import { tieredPricing } from "../src/tieredPricing";

describe("TieredPricing should", () => {
  test("return 299 for a unique license", async () => {
    expect(tieredPricing(1)).toBe(299);
  });
});
