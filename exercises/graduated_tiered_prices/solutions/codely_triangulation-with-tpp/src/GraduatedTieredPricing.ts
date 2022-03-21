import { Tier } from "./Tier";

export class GraduatedTieredPricing {
  for(subscriptions: number): number {
    const tier1 = new Tier(1, 2, 299);
    const tier2 = new Tier(3, 10, 239);
    const tier3 = new Tier(11, 25, 219);

    const tier1size = tier1.size();
    const tier1total = tier1.fullTierTotal();
    const tier2size = tier2.size();
    const tier2total = tier2.fullTierTotal();
    const tier3price = tier3.price;

    if (subscriptions >= 11) {
      return (
        tier1total +
        tier2total +
        (subscriptions - tier1size - tier2size) * tier3price
      );
    }

    if (subscriptions >= 3) {
      return tier1total + (subscriptions - tier1size) * 239;
    }

    return subscriptions * 299;
  }
}
