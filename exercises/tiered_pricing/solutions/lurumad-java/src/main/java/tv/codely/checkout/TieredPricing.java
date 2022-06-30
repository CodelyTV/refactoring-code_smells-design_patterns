package tv.codely.checkout;

public class TieredPricing {
    private VolumePricingList volumePricingList;

    public TieredPricing(VolumePricingList volumePricingList) {
        this.volumePricingList = volumePricingList;
    }

    public Price calculateFor(Subscriptions subscriptions) {
        Price price = volumePricingList.findPrice(subscriptions.volume());
        return Price.of(price.amount() * subscriptions.volume(), price.currency());
    }
}
