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

  test("return 2409 for eleven licenses", async () => {
    expect(tieredPricing(11)).toBe(2409);
  });

  test("return 5373 for twenty seven licenses", async () => {
    expect(tieredPricing(27)).toBe(5373);
  });
});
