package tv.codely.checkout;

import java.util.TreeMap;

public record VolumePricingList(TreeMap<Integer, Price> list) {
    public Price findPrice(int licenses) {
        return list.floorEntry(licenses).getValue();
    }
}
