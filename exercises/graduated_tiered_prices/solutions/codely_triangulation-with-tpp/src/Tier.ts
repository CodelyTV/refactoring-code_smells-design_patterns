import { SubscriptionsBeingPurchased } from "./SubscriptionsBeingPurchased";

export class Tier {
  constructor(
    public readonly from: number,
    public readonly to: number,
    public readonly price: number
  ) {}

  size(): number {
    return this.to - this.from + 1;
  }

  private fullTierTotal(): number {
    return this.size() * this.price;
  }

  totalFor(subscriptions: SubscriptionsBeingPurchased): number {
    if (subscriptions.covers(this)) {
      return this.fullTierTotal();
    }

    if (!subscriptions.reaches(this)) {
      return 0;
    }
    1;
    return subscriptions.numberOfSubscriptionsInTier(this) * this.price;
  }
}
