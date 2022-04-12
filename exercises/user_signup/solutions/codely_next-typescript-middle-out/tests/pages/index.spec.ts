describe("The sign up user form", () => {
  it("displays success message on form submission", () => {
    cy.visit("/");
    const name = "Jane Doe";
    const email = "jane@gmail.com";

    cy.find
    cy.findByLabelText(/name/i)
      .type(name);
    cy.findByLabelText(/email/i)
      .type(email);

    cy.findByRole("button", { name: /submit/i })
      .click()

    const successMessage = cy.findByText(/thank you/i)

    successMessage.should("exist");
  });

  it("displays error message on form submission if data is incorrect", () => {
    cy.visit("/");
    const name = "J";
    const email = "jane@gmail.com";

    cy.find
    cy.findByLabelText(/name/i)
      .type(name);
    cy.findByLabelText(/email/i)
      .type(email);

    cy.findByRole("button", { name: /submit/i })
      .click()

    const successMessage = cy.findByText(/an error ocurred/i)

    successMessage.should("exist");
  });
});
