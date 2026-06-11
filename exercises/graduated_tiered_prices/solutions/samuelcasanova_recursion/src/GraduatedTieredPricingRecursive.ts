export class GraduatedTieredPricingRecursive {
  tiers = [
    { min: 1, max: 2, price: 299 },
    { min: 3, max: 10, price: 239 },
    { min: 11, max: 25, price: 219 },
    { min: 26, max: 50, price: 199 },
    { min: 51, max: Number.MAX_VALUE, price: 149 },
  ];
  getPriceForOrdinal(ordinal: number): number {
    const tier = this.tiers.find(
      (tier) => ordinal >= tier.min && ordinal <= tier.max
    );

    if (tier === undefined) {
      return this.tiers[0].price;
    }

    return tier.price;
  }

  for(subscriptions: number): number {
    if (subscriptions === 0) {
      return 0;
    }
    return this.getPriceForOrdinal(subscriptions) + this.for(subscriptions - 1);
  }
}
