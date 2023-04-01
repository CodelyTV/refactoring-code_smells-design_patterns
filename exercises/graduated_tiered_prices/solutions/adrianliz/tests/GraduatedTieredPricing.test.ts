class GraduatedTieredPricing {
  priceFor(subscriptions: number): number {
    throw new Error("Not implemented yet");
  }
}

describe("Graduated tiered pricing should", () => {
  it("calculate the price for 1 subscription", () => {
    const pricing = new GraduatedTieredPricing();
    expect(pricing.priceFor(1)).toBe(299);
  });
});

test("test framework working", async () => {
  expect(true).toBe(true);
});
