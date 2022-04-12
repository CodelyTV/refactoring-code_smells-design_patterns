describe("The Home Page", () => {
  it("works", () => {
    
    cy.visit("/")
      .contains("User Signup")
      .should("exist");
  });
});
