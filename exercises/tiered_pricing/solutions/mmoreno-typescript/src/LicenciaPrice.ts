import LicenciaQuantity from "./LicenciaQuantity";

export default class LicenciaPrice {
  constructor(private price: number) {}

  value(): number {
    return this.price;
  }
  static calculatePrice(cantidad: LicenciaQuantity): LicenciaPrice {
    const isBetween = this.isBetween(cantidad);

    if (isBetween(1, 2)) {
      return new LicenciaPrice(299);
    }

    if (isBetween(3, 10)) {
      return new LicenciaPrice(239);
    }

    if (isBetween(11, 25)) {
      return new LicenciaPrice(219);
    }

    if (isBetween(26, 50)) {
      return new LicenciaPrice(199);
    }

    return new LicenciaPrice(149);
  }

  private static isBetween(cantidad: LicenciaQuantity) {
    return (first: number, last: number) => {
      return cantidad.value >= first && cantidad.value <= last;
    };
  }
}
