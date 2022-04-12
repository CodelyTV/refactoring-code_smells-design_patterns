import userEvent from "@testing-library/user-event";
import { render, screen } from "@testing-library/react";

import { SignUpForm } from "../../src/components/SignUpForm";

import { signUpUser } from "../../src/services/signUpUser";

jest.mock("../../src/services/signUpUser.ts");
const mockSignUpUser = signUpUser as jest.Mock<Promise<void>>;

describe("SignUpForm component", () => {
  it("displays success message after correct submission", async () => {
    render(<SignUpForm />);
    mockSignUpUser.mockResolvedValue();

    const nameField = screen.getByLabelText(/name/i);
    const emailField = screen.getByLabelText(/email/i);

    const name = "Jane Doe";
    const email = "jane@gmail.com";
    
    userEvent.type(nameField, name)
    userEvent.type(emailField, email)

    const button = screen.getByRole("button", { name: /submit/i })
    userEvent.click(button)

    const successMessage = await screen.findByText(/thank you/i)

    expect(successMessage).toBeInTheDocument();
    expect(mockSignUpUser).toHaveBeenCalledWith({ name, email })
  });

  it("displays error message after submission fails", async () => {
    render(<SignUpForm />);
    mockSignUpUser.mockRejectedValue(new Error());

    const nameField = screen.getByLabelText(/name/i);
    const emailField = screen.getByLabelText(/email/i);

    const name = "Jane Doe";
    const email = "jane@gmail.com";

    userEvent.type(nameField, name)
    userEvent.type(emailField, email)

    const button = screen.getByRole("button", { name: /submit/i })
    userEvent.click(button)

    const errorMessage = await screen.findByText(/an error ocurred/i)

    expect(errorMessage).toBeInTheDocument();
  });
});
