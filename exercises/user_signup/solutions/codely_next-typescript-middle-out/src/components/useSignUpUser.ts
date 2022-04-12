import { useState } from "react";
import { signUpUser } from "../services/signUpUser";

type FormStatus = "success" | "error" | "initial"

export function useSignUpUser() {
  const [formStatus, setFormStatus] = useState<FormStatus>("initial")

  function signUp({name, email}: {name: string; email: string;}) {
    return signUpUser({name, email})
      .then(() => {
        setFormStatus("success");
      })
      .catch(() => {
        setFormStatus("error");
      });
  }

  return {
    signUp,
    formStatus
  }
}
