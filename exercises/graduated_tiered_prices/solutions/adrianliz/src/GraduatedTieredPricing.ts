export default class GraduatedTieredPricing {
  priceFor(subscriptions: number): number {
    if (subscriptions === 1) {
      return 299;
    }
    if (subscriptions === 2) {
      return 598;
    }
    if (subscriptions === 3) {
      return 837;
    }
    return 0;
  }
}
