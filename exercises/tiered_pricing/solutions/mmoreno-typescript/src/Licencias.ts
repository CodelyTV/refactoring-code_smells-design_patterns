import InvalidLicenciasQuantity from "./InvalidLicenciasQuantity";
import LicenciaPrice from "./LicenciaPrice";
import LicenciaQuantity from "./LicenciaQuantity";

export default class Licencias {
  constructor(private cantidad: LicenciaQuantity) {
    if (cantidad.value < 0) {
      throw new InvalidLicenciasQuantity();
    }
  }

  total(): number {
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(this.cantidad);
    return this.cantidad.value * precio.value();
  }
}
