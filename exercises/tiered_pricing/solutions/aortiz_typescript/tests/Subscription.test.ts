import { InvalidUnitException } from "../src/InvalidUnitException";
import { Subscription } from "../src/Subscription";

describe("Subscription", () => {
  it("can be instantiated without throwing errors", () => {
    expect(() => new Subscription(1)).not.toThrow(TypeError);
  });

  it("can be calculate subscription price of 1 unit", () => {
    const subscription = new Subscription(1);

    expect(subscription.getTotalPrice()).toBe(299);
  });

  it("can be calculate subscription price of 2 unit", () => {
    const subscription = new Subscription(2);

    expect(subscription.getTotalPrice()).toBe(598);
  });

  it("can be calculate subscription price of 10 units", () => {
    const subscription = new Subscription(10);

    expect(subscription.getTotalPrice()).toBe(2390);
  });

  it("can be calculate subscription price of 25 units", () => {
    const subscription = new Subscription(25);

    expect(subscription.getTotalPrice()).toBe(5475);
  });

  it("can be calculate subscription price of 50 units", () => {
    const subscription = new Subscription(50);

    expect(subscription.getTotalPrice()).toBe(9950);
  });

  it("can be calculate subscription price of 68 units", () => {
    const subscription = new Subscription(68);

    expect(subscription.getTotalPrice()).toBe(10132);
  });

  it("should be throw InvalidUnitException", () => {
    expect(() => new Subscription(-1)).toThrow(InvalidUnitException);
  });
});
