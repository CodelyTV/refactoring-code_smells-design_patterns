import GraduatedTier from "../src/GraduatedTier";
import InvalidTier from "../src/InvalidTier";

describe("Graduated tiered should", () => {
  it("throw number of subscriptions not allowed for 0 subscriptions", () => {
    expect(() => GraduatedTier.firstTier(0, 199)).toThrow(InvalidTier);
  });
});
