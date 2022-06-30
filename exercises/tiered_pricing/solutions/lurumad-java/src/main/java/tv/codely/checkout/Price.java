package tv.codely.checkout;

public record Price(float amount, String currency) {
    public Price {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can not be less than 0");
        }
    }

    public static Price of(float amount, String currency) {
        return new Price(amount, currency);
    }
}
