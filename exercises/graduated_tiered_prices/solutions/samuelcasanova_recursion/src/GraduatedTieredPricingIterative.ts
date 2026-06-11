export class GraduatedTieredPricingIterative {
  tiers = [
    { min: 1, max: 2, price: 299 },
    { min: 3, max: 10, price: 239 },
    { min: 11, max: 25, price: 219 },
    { min: 26, max: 50, price: 199 },
    { min: 51, max: Number.MAX_VALUE, price: 149 },
  ];

  for(subscriptions: number): number {
    let price = 0;
    for (const tier of this.tiers) {
      if (subscriptions > tier.max) {
        price += tier.price * (tier.max - tier.min + 1);
        continue;
      }
      return price + tier.price * (subscriptions - tier.min + 1);
    }
    return price;
  }
}
