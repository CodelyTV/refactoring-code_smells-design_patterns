package tv.codely.ecommerce.sign_up;

public final class EmailSignUpProvider extends SignUpProvider {
    private final String email;
    private final String password;

    public EmailSignUpProvider(String email, String password) {
        super("email");
        this.email = email;
        this.password = password;
    }
}
