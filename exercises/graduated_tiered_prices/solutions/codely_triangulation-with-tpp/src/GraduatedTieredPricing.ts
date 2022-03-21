import { SubscriptionsBeingPurchased } from "./SubscriptionsBeingPurchased";
import { Tier } from "./Tier";

export class GraduatedTieredPricing {
  for(subscriptions: SubscriptionsBeingPurchased): number {
    const tiers = [
      new Tier(1, 2, 299),
      new Tier(3, 10, 239),
      new Tier(11, 25, 219),
      new Tier(26, 50, 199),
    ];

    return tiers.reduce((total: number, tier: Tier) => {
      return total + tier.totalFor(subscriptions);
    }, 0);
  }
}
