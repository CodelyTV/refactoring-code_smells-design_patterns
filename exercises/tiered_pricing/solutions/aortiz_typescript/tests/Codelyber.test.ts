import { Codelyber } from "../src/Codelyber";

describe("Codelyber", () => {
  it("can be instantiated without throwing errors", () => {
    const randomCodelyberInstantiator = () => {
      new Codelyber("Isma");
    };

    expect(randomCodelyberInstantiator).not.toThrow(TypeError);
  });

  it("greets", () => {
    const randomCodelyber = new Codelyber("Javi");

    const expectedGreeting = "Hi Javi from Codely TypeScript Basic Skeleton!";

    expect(randomCodelyber.greet()).toEqual(expectedGreeting);
  });
});
