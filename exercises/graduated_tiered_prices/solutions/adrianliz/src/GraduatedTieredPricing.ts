import GraduatedTier from "./GraduatedTier";
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

  priceFor(subscriptions: Subscriptions): number {
    return subscriptions.priceFor(this.tiers());
  }
}
