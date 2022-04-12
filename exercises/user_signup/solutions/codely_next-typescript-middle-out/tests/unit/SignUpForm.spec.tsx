import userEvent from "@testing-library/user-event";
import { render, screen } from "@testing-library/react";

import { SignUpForm } from "../../src/components/SignUpForm";

describe("SignUpForm component", () => {
  it("displays success message after correct submission", async () => {
    render(<SignUpForm />);
    
    const nameField = screen.getByLabelText(/name/i);
    const emailField = screen.getByLabelText(/email/i);
    
    userEvent.type(nameField, "Jane Doe")
    userEvent.type(emailField, "jane@gmail.com")

    const button = screen.getByRole("button", { name: /submit/i })
    userEvent.click(button)

    const successMessage = await screen.findByText(/thank you/i)

    expect(successMessage).toBeInTheDocument();
  });
});
