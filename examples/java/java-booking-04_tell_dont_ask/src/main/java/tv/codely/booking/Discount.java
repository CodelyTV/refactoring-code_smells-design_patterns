package tv.codely.booking;

public final class Discount {
    private final DiscountType  type;
    private final DiscountValue value;

    public Discount(DiscountType type, DiscountValue value) {
        this.type  = type;
        this.value = value;
    }
}
