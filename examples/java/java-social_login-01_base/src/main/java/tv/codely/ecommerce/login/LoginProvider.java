package tv.codely.ecommerce.login;

public abstract class LoginProvider {
    private String provider;
    private String ip;

    public LoginProvider(String provider, String ip) {
        this.provider = provider;
        this.ip       = ip;
    }
}
