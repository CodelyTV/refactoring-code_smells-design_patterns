import InvalidTier from "./InvalidTier";
import Subscriptions from "./Subscriptions";

export default class GraduatedTier {
  private constructor(
    private readonly from: number,
    private readonly to: number,
    private readonly singleSubscriptionPrice: number
  ) {
    GraduatedTier.validate(from, to, singleSubscriptionPrice);
  }

  static firstTier(
    numberOfSubscriptionsIn: number,
    singleSubscriptionPrice: number
  ): GraduatedTier {
    return new GraduatedTier(
      1,
      numberOfSubscriptionsIn,
      singleSubscriptionPrice
    );
  }

  static fromTier(
    from: GraduatedTier,
    numberOfSubscriptionsIn: number,
    singleSubscriptionPrice: number
  ): GraduatedTier {
    const newFrom = from.to + 1;
    const newTo = newFrom + (numberOfSubscriptionsIn - 1);
    return new GraduatedTier(newFrom, newTo, singleSubscriptionPrice);
  }

  static lastTier(
    from: GraduatedTier,
    singleSubscriptionPrice: number
  ): GraduatedTier {
    return new GraduatedTier(
      from.to + 1,
      Number.MAX_SAFE_INTEGER,
      singleSubscriptionPrice
    );
  }

  private static validate(
    from: number,
    to: number,
    singleSubscriptionPrice: number
  ): void {
    if (singleSubscriptionPrice <= 0) {
      throw new InvalidTier();
    }

    if (from < 1) {
      throw new InvalidTier();
    }

    if (from > to) {
      throw new InvalidTier();
    }

    if (to > Number.MAX_SAFE_INTEGER) {
      throw new InvalidTier();
    }
  }

  private total(): number {
    return this.size() * this.singleSubscriptionPrice;
  }

  size(): number {
    return this.to - this.from + 1;
  }

  covers(subscriptions: number): boolean {
    return subscriptions >= this.to;
  }

  reaches(subscriptions: number): boolean {
    return subscriptions >= this.from;
  }

  numberOfSubscriptionsInside(subscriptions: number): number {
    return subscriptions - this.from + 1;
  }

  totalFor(subscriptions: Subscriptions): number {
    if (subscriptions.covers(this)) {
      return this.total();
    }

    if (!subscriptions.reaches(this)) {
      return 0;
    }

    return (
      subscriptions.numberOfSubscriptionsInTier(this) *
      this.singleSubscriptionPrice
    );
  }
}
