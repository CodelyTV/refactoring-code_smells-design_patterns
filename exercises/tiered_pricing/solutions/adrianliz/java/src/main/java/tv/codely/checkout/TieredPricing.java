package tv.codely.checkout;

import java.util.List;

public class TieredPricing {

    private final List<PriceRange> priceRanges;

    public TieredPricing(final List<PriceRange> priceRanges) {
        this.priceRanges = priceRanges;
    }

    public TieredPricing() {
        this(List.of(
            new PriceRange(1, 2, 299),
            new PriceRange(3, 10, 239),
            new PriceRange(11, 25, 219),
            new PriceRange(26, 50, 199),
            new PriceRange(51, 100, 149)));
    }

    public double getTotalPrice(int subscriptions) {
        return priceRanges.stream().filter(priceRange -> priceRange.isInRange(subscriptions))
            .findFirst()
            .map(priceRange -> priceRange.getTotalPrice(subscriptions))
            .orElse(0D);
    }
}
