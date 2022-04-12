import React, { useState } from "react";
import { Input } from "./Input";

type FormStatus = "success" | "error" | "initial"

export function SignUpForm() {
  const [formStatus, setFormStatus] = useState<FormStatus>("initial")

  function handleSubmit(ev: React.FormEvent) {
    ev.preventDefault()
    setFormStatus("success")
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
