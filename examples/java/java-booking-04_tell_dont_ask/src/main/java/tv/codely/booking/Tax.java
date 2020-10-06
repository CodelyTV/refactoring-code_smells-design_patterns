package tv.codely.booking;

public final class Tax {
    private final TaxType type;
    private final TaxValue value;

    public Tax(TaxType type, TaxValue value) {
        this.type  = type;
        this.value = value;
    }
}
