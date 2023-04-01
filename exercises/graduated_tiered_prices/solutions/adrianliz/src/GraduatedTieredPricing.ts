export default class GraduatedTieredPricing {
  priceFor(subscriptions: number): number {
    const step1Price = 299;
    const step2Price = 239;

    if (subscriptions <= 2) {
      return subscriptions * step1Price;
    }
    if (subscriptions <= 5) {
      return 2 * step1Price + (subscriptions - 2) * step2Price;
    }
    throw new Error("Not implemented yet");
  }
}
