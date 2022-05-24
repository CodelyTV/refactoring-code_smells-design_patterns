import { Subscription } from "../src/Subscription";

describe("Subscription", () => {
  it("can be instantiated without throwing errors", () => {
    expect(() => new Subscription(1)).not.toThrow(TypeError);
  });

  it("can be calculate subscription price of 1 unit", () => {
    const subscription = new Subscription(1);

    expect(subscription.getTotalPrice()).toBe(299);
  });
});
