export class Tier {
  constructor(
    public readonly from: number,
    public readonly to: number,
    public readonly price: number
  ) {}

  size(): number {
    return this.to - this.from + 1;
  }

  fullTierTotal(): number {
    return this.size() * this.price;
  }

  totalFor(subscriptions: number): number {
    if (subscriptions >= this.to) {
      return this.fullTierTotal();
    }

    if (subscriptions < this.from) {
      return 0;
    }

    return (subscriptions - this.from + 1) * this.price;
  }
}
