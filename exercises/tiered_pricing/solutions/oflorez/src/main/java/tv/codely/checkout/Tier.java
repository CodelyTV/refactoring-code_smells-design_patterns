package tv.codely.checkout;


enum Tier {

    FIRST(1,2,299),
    SECOND(3,10,239),
    THIRD(11,25,219),
    FOURTH(26,50,199),
    FIFTH(51,Integer.MAX_VALUE,149);

    private final int lowerLimit;
    private final int upperLimit;
    private final int unitPrice;

    Tier(int lowerLimit, int upperLimit, int unitPrice) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.unitPrice = unitPrice;
    }

    int getLowerLimit() {
        return lowerLimit;
    }

    int getUpperLimit() {
        return upperLimit;
    }

    int getUnitPrice() {
        return unitPrice;
    }

    static int getTotalPrice(int subscriptions) {
        var found = FIRST;
        for (Tier tier : values()) {
            if ( subscriptions >= tier.lowerLimit && subscriptions <= tier.upperLimit) {
                found = tier;
                break;
            }
        }

        return subscriptions * found.unitPrice;
    }
}
