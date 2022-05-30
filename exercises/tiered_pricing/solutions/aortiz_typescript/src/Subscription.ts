import {InvalidUnitException} from "./InvalidUnitException";

export class Subscription {
  private tieredPrice!: number;

  constructor(private units: number) {
    this.setTieredPrice();
  }

  private setTieredPrice() {
    if (this.units <= 0) {
      throw new InvalidUnitException("Unit should be greater than zero");
    } else if (this.units < 3) {
      this.tieredPrice = 299;
    } else if (this.units < 11) {
      this.tieredPrice = 239;
    } else if (this.units < 26) {
      this.tieredPrice = 219;
    } else if (this.units < 51) {
      this.tieredPrice = 199;
    } else {
      this.tieredPrice = 149;
    }
  }

  getTotalPrice() {
    return this.tieredPrice * this.units;
  }
}
