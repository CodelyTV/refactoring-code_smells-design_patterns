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
}
