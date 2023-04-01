import GraduatedTier from "./GraduatedTier";
import NumberOfSubscriptionsNotAllowed from "./NumberOfSubscriptionsNotAllowed";

export default class Subscriptions {
  constructor(private readonly subscriptions: number) {
    if (subscriptions < 1) {
      throw new NumberOfSubscriptionsNotAllowed();
    }
  }

  priceFor(tiers: GraduatedTier[]): number {
    return tiers.reduce(
      (total, tier) => total + tier.totalFor(this.subscriptions),
      0
    );
  }
}
