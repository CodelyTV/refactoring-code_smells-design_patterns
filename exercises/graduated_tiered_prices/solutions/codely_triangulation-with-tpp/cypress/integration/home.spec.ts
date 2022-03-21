describe("The Home Page", () => {
  it("successfully loads", () => {
    cy.visit("/");
    cy.findByRole("heading", { name: /product pricing/i }).should("exist");
  });
});
