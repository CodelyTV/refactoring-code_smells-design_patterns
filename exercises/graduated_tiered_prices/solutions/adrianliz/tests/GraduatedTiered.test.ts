import GraduatedTier from "../src/GraduatedTier";
import InvalidTier from "../src/InvalidTier";

describe("Graduated tiered should", () => {
  it("throw invalid tier for 0 subscriptions in tier", () => {
    expect(() => GraduatedTier.firstTier(0, 199)).toThrow(InvalidTier);
  });

  it("throw invalid tier for -100 subscriptions in tier", () => {
    const firstTier = GraduatedTier.firstTier(2, 199);
    expect(() => GraduatedTier.fromTier(firstTier, -100, 150)).toThrow(
      InvalidTier
    );
  });

  it("throw invalid tier for single subscription price of 0 in tier", () => {
    expect(() => GraduatedTier.firstTier(2, 0)).toThrow(InvalidTier);
  });

  it("work for 1 subscription in tier", () => {
    const firstTier = GraduatedTier.firstTier(1, 199);
    GraduatedTier.fromTier(firstTier, 1, 150);
  });
});
