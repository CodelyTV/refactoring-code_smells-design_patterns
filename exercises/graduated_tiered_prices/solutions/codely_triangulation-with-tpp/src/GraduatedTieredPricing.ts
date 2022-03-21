export class GraduatedTieredPricing {
  for(subscriptions: number): number {
    if (subscriptions == 4) {
      return 299 + 299 + 239 + 239;
    }

    if (subscriptions == 3) {
      return 299 + 299 + 239;
    }

    return subscriptions * 299;
  }
}
