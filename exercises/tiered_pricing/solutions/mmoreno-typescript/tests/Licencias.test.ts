import InvalidLicenciasQuantity from "../src/InvalidLicenciasQuantity";
import LicenciaPrice from "../src/LicenciaPrice";
import LicenciaQuantity from "../src/LicenciaQuantity";
import Licencias from "../src/Licencias";
import numberRandomBetween from "./NumberRandomBetween";

describe("Licencias Should", () => {
  test("the licence's quantity, cant't to be negative", () => {
    expect(() => new Licencias(new LicenciaQuantity(-1))).toThrow(
      InvalidLicenciasQuantity
    );
  });

  test("TODO: Precio de 1-2  licencias es 299 c/u", () => {
    const expectedPrice = 299;
    const cantidadRandom: number = numberRandomBetween(1, 2);
    const cantidad: LicenciaQuantity = new LicenciaQuantity(cantidadRandom);
    const licencias = new Licencias(cantidad);
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(cantidad);

    expect(precio.value()).toBe(expectedPrice);
    expect(licencias.total()).toBe(cantidad.value * expectedPrice);
  });

  test("total de 3-10 licencias es 239 c/u", () => {
    const expectedPrice = 239;
    const cantidadRandom = numberRandomBetween(3, 10);
    const cantidad: LicenciaQuantity = new LicenciaQuantity(cantidadRandom);
    const licencias = new Licencias(cantidad);
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(cantidad);

    expect(precio.value()).toBe(expectedPrice);
    expect(licencias.total()).toBe(cantidad.value * expectedPrice);
  });

  test("total de 11-25 licencias es 219 c/u", () => {
    const expectedPrice = 219;
    const cantidadRandom = numberRandomBetween(11, 25);
    const cantidad: LicenciaQuantity = new LicenciaQuantity(cantidadRandom);
    const licencias = new Licencias(cantidad);
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(cantidad);

    expect(precio.value()).toBe(expectedPrice);
    expect(licencias.total()).toBe(cantidad.value * expectedPrice);
  });

  test("total de 26-50 licencias es 199 c/u", () => {
    const expectedPrice = 199;
    const cantidadRandom = numberRandomBetween(26, 50);
    const cantidad: LicenciaQuantity = new LicenciaQuantity(cantidadRandom);
    const licencias = new Licencias(cantidad);
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(cantidad);

    expect(precio.value()).toBe(expectedPrice);
    expect(licencias.total()).toBe(cantidad.value * expectedPrice);
  });

  test("total de 51+ licencias es 149 c/u", () => {
    const expectedPrice = 149;
    const cantidadRandom = numberRandomBetween(51, 200);
    const cantidad: LicenciaQuantity = new LicenciaQuantity(cantidadRandom);
    const licencias = new Licencias(cantidad);
    const precio: LicenciaPrice = LicenciaPrice.calculatePrice(cantidad);

    expect(precio.value()).toBe(expectedPrice);
    expect(licencias.total()).toBe(cantidad.value * expectedPrice);
  });
});
