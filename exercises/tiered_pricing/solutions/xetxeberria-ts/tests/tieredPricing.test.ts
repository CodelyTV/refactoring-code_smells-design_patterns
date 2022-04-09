import { tieredPricing } from "../src/tieredPricing";

describe("TieredPricing should", () => {
  test("return 299 for a unique license", async () => {
    expect(tieredPricing(1)).toBe(299);
  });

  test("return 598 for two licenses", async () => {
    expect(tieredPricing(2)).toBe(598);
  });

  test("return 717 for three licenses", async () => {
    expect(tieredPricing(3)).toBe(717);
  });
});
