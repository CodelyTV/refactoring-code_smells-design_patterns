import { render, screen } from "@testing-library/react";
import Home from "../../src/pages/index";

describe("index component", () => {
  it("works", () => {
    
    render(<Home />);

    expect(screen.getByText("User Signup")).toBeInTheDocument();
  });
});
