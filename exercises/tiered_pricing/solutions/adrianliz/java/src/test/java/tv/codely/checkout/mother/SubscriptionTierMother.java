package tv.codely.checkout.mother;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tv.codely.checkout.SubscriptionTier;
import tv.codely.checkout.SubscriptionTierPrice;
import tv.codely.checkout.SubscriptionTierRange;

public final class SubscriptionTierMother {

    public static SubscriptionTier create(
        final SubscriptionTierRange range,
        final SubscriptionTierPrice price) {

        return new SubscriptionTier(range, price);
    }

    public static List<SubscriptionTier> randoms() {
        final var subscriptionTierRanges = SubscriptionTierRangeMother.randoms();
        final var previousSubscriptionTierPrice = new AtomicReference<>(299D);
        
        return subscriptionTierRanges.stream()
            .map(range -> {
                final var subscriptionTierPrice =
                    DoubleMother.randomBetween(
                        previousSubscriptionTierPrice.get().intValue() - 60,
                        previousSubscriptionTierPrice.get().intValue() - 20);
                previousSubscriptionTierPrice.set(subscriptionTierPrice);
                return create(range, new SubscriptionTierPrice(subscriptionTierPrice));
            })
            .toList();
    }
}
