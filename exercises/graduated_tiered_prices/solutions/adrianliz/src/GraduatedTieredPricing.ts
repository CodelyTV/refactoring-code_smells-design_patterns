import NumberOfSubscriptionsNotAllowed from "./NumberOfSubscriptionsNotAllowed";
import Tier from "./Tier";

export default class GraduatedTieredPricing {
  priceFor(subscriptions: number): number {
    if (subscriptions < 1) {
      throw new NumberOfSubscriptionsNotAllowed();
    }

    const tiers = [
      new Tier(1, 2, 299),
      new Tier(3, 10, 239),
      new Tier(11, 25, 219),
      new Tier(26, 50, 199),
      new Tier(51, Number.MAX_SAFE_INTEGER, 149),
    ];

    return (
      tiers[0].totalFor(subscriptions) +
      tiers[1].totalFor(subscriptions) +
      tiers[2].totalFor(subscriptions) +
      tiers[3].totalFor(subscriptions) +
      tiers[4].totalFor(subscriptions)
    );
  }
}
