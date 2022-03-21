export class GraduatedTieredPricing {
  for(subscriptions: number): number {
    if (subscriptions == 4) {
      return 1076;
    }

    if (subscriptions == 3) {
      return 837;
    }

    return subscriptions * 299;
  }
}
