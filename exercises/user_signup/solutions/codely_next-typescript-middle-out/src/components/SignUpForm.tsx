import { Input } from "./Input";
import { useSignUpUser } from "./useSignUpUser";

export function SignUpForm() {
  const {formStatus, signUp} = useSignUpUser();

  async function handleSubmit(ev: React.FormEvent) {
    ev.preventDefault()
    const data = new FormData(ev.target as HTMLFormElement);
    const entries = Object.fromEntries(data.entries()) as { [key: string]: string };

    return signUp({name: entries.name, email: entries.email});
  }

  if (formStatus === "success") {
    return (
      <h1>Thank you!</h1>
    )
  }

  return (<form onSubmit={handleSubmit}>
    {
      formStatus === "error" && (<div>An error ocurred. Please try again</div>)
    }
    <Input label="Name" id="name" />
    <Input type="email" label="Email" id="email"  />
    <button type="submit">Submit</button>
  </form>)
}
