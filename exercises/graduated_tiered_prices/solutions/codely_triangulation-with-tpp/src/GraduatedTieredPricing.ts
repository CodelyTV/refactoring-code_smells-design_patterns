export class GraduatedTieredPricing {
  for(subscriptions: number): number {
    const tier1total = 299 + 299;

    if (subscriptions == 5) {
      return tier1total + 239 + 239 + 239;
    }

    if (subscriptions == 4) {
      return tier1total + 239 + 239;
    }

    if (subscriptions == 3) {
      return tier1total + 239;
    }

    return subscriptions * 299;
  }
}
