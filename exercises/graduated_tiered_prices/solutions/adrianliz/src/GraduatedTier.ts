import Subscriptions from "./Subscriptions";

export default class GraduatedTier {
  constructor(
    private readonly from: number,
    private readonly to: number,
    private readonly price: number
  ) {}

  private total(): number {
    return this.size() * this.price;
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

    return subscriptions.numberOfSubscriptionsInTier(this) * this.price;
  }
}
