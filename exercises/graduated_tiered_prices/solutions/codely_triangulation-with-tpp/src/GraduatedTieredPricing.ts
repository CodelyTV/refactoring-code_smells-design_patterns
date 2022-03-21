export class GraduatedTieredPricing {
  for(subscriptions: number): number {
    const tier1size = 2;
    const tier1price = 299;
    const tier1total = tier1size * tier1price;
    const tier2size = 8;
    const tier2price = 239;
    const tier2total = tier2size * tier2price;
    const tier3price = 219;

    if (subscriptions == 12) {
      return tier1total + tier2total + 2 * tier3price;
    }

    if (subscriptions == 11) {
      return tier1total + tier2total + tier3price;
    }

    if (subscriptions >= 3) {
      return tier1total + (subscriptions - tier1size) * 239;
    }

    return subscriptions * 299;
  }
}
