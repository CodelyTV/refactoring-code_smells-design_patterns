import GraduatedTier from "./GraduatedTier";
import NumberOfSubscriptionsNotAllowed from "./NumberOfSubscriptionsNotAllowed";
import Subscriptions from "./Subscriptions";

export default class GraduatedTieredPricing {
  private tiers(): GraduatedTier[] {
    return [
      new GraduatedTier(1, 2, 299),
      new GraduatedTier(3, 10, 239),
      new GraduatedTier(11, 25, 219),
      new GraduatedTier(26, 50, 199),
      new GraduatedTier(51, Number.MAX_SAFE_INTEGER, 149),
    ];
  }

  priceFor(subscriptions: number): number {
    if (subscriptions < 1) {
      throw new NumberOfSubscriptionsNotAllowed();
    }

    const tiers = this.tiers();

    return (
      tiers[0].totalFor(subscriptions) +
      tiers[1].totalFor(subscriptions) +
      tiers[2].totalFor(subscriptions) +
      tiers[3].totalFor(subscriptions) +
      tiers[4].totalFor(subscriptions)
    );
  }

  priceFor2(subscriptions: Subscriptions): number {
    return subscriptions.priceFor(this.tiers());
  }
}
