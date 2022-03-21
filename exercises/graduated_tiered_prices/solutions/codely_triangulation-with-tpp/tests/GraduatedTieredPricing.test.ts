import { GraduatedTieredPricing } from "../src/GraduatedTieredPricing";
import { SubscriptionsBeingPurchased } from "../src/SubscriptionsBeingPurchased";

describe("Graduated tiered pricing should", () => {
  test("return 299€ for 1 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(1));

    expect(total).toBe(299);
  });

  test("return 598€ for 2 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(2));

    expect(total).toBe(598);
  });

  test("return 837€ for 3 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(3));

    expect(total).toBe(837);
  });

  test("return 1076€ for 4 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(4));

    expect(total).toBe(1076);
  });

  test("return 1315€ for 5 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(5));

    expect(total).toBe(1315);
  });

  test("return 2729€ for 11 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(11));

    expect(total).toBe(2729);
  });

  test("return 2948€ for 12 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(12));

    expect(total).toBe(2948);
  });

  test("return 5994€ for 26 subscription", async () => {
    const pricing = new GraduatedTieredPricing();

    const total = pricing.for(new SubscriptionsBeingPurchased(26));

    expect(total).toBe(5994);
  });
});
