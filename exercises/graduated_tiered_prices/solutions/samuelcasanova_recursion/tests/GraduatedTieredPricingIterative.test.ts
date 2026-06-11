import { GraduatedTieredPricingIterative } from "../src/GraduatedTieredPricingIterative";

describe("Graduated tiered pricing should", () => {
  test("return 299€ for 1 subscription", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(1);

    expect(total).toBe(299);
  });

  test("return 598€ for 2 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(2);

    expect(total).toBe(598);
  });

  test("return 837€ for 3 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(3);

    expect(total).toBe(837);
  });

  test("return 1315€ for 5 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(5);

    expect(total).toBe(1315);
  });

  test("return 2729€ for 11 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(11);

    expect(total).toBe(2729);
  });

  test("return 5994€ for 26 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(26);

    expect(total).toBe(5994);
  });

  test("return 10770€ for 50 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(50);

    expect(total).toBe(10770);
  });

  test("return 10919€ for 51 subscriptions", async () => {
    const pricing = new GraduatedTieredPricingIterative();

    const total = pricing.for(51);

    expect(total).toBe(10919);
  });
});
