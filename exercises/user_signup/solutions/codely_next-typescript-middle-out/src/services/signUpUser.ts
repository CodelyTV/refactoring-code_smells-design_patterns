export async function signUpUser(userData: {name: string, email: string}): Promise<void> {
  await fetch("/api/signup", {
    method: "POST",
    body: JSON.stringify(userData),
    headers: {
      "Content-Type": "application/json",
    },
  })
  .then(response => {
    if (response.status !== 200) {
      throw new Error()
    }
  })
}
