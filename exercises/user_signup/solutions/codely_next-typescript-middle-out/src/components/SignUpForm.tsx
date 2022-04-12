import React, { useState } from "react";
import { signUpUser } from "../services/signUpUser";
import { Input } from "./Input";

type FormStatus = "success" | "error" | "initial"

export function SignUpForm() {
  const [formStatus, setFormStatus] = useState<FormStatus>("initial")

  async function handleSubmit(ev: React.FormEvent) {
    ev.preventDefault()
    const data = new FormData(ev.target as HTMLFormElement);
    const entries = Object.fromEntries(data.entries()) as { [key: string]: string };

    await signUpUser({name: entries.name, email: entries.email});
    setFormStatus("success");
  }

  if (formStatus === "success") {
    return (
      <h1>Thank you!</h1>
    )
  }

  return (<form onSubmit={handleSubmit}>
    <Input label="Name" id="name" />
    <Input type="email" label="Email" id="email"  />
    <button type="submit">Submit</button>
  </form>)
}
