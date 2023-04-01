import GraduatedTier from "./GraduatedTier";
import Subscriptions from "./Subscriptions";

export default class GraduatedTieredPricing {
  constructor(private readonly tiers: GraduatedTier[]) {}

  priceFor(subscriptions: Subscriptions): number {
    return subscriptions.priceFor(this.tiers);
  }
}
