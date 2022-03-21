import { Tier } from "./Tier";

export class SubscriptionsBeingPurchased {
  constructor(private value: number) {}

  covers(tier: Tier): boolean {
    return this.value >= tier.to;
  }

  reaches(tier: Tier): boolean {
    return this.value >= tier.from;
  }

  numberOfSubscriptionsInTier(tier: Tier): number {
    return this.value - tier.from + 1;
  }
}
