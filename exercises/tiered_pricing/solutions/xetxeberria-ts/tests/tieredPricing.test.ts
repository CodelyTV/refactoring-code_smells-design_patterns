import { tieredPricing } from "../src/tieredPricing";

describe("TieredPricing should", () => {
  test("return 299 for a unique license", async () => {
    expect(tieredPricing(1)).toBe(299);
  });

  test("return 598 for 2 licenses", async () => {
    expect(tieredPricing(2)).toBe(598);
  });

  test("return 717 for 3 licenses", async () => {
    expect(tieredPricing(3)).toBe(717);
  });

  test("return 2409 for 11 licenses", async () => {
    expect(tieredPricing(11)).toBe(2409);
  });

  test("return 5373 for 27 licenses", async () => {
    expect(tieredPricing(27)).toBe(5373);
  });

  test("return 7599 for 51 licenses", async () => {
    expect(tieredPricing(51)).toBe(7599);
  });

  test("return 0 for 0 licenses", async () => {
    expect(tieredPricing(0)).toBe(0);
  });

  test("throw an error if the license amount is negative", async () => {
    expect(() => tieredPricing(-1)).toThrow(Error);
  });
});
