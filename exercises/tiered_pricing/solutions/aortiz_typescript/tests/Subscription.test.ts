describe("Codelyber", () => {
  it("can be instantiated without throwing errors", () => {
    expect(() => new Subscription(1)).not.toThrow(TypeError);
  });
});
