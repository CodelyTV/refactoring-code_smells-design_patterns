package tv.codely.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.util.streamex.StreamEx;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TieredPricingShould {
  private static final IntStream FIRST_TIER_RANGE  = IntStream.rangeClosed(1, 2);
  private static final IntStream SECOND_TIER_RANGE = IntStream.rangeClosed(3, 10);
  private static final IntStream THIRD_TIER_RANGE  = IntStream.rangeClosed(11, 25);
  private static final IntStream FOURTH_TIER_RANGE = IntStream.rangeClosed(26, 50);

  private TieredPricing tieredPricing;

  @BeforeEach
  void setUp() {
    tieredPricing = new TieredPricing();
  }

  @ParameterizedTest(name = "{0} subscriptions should be charged {1} each")
  @MethodSource("tierRanges")
  void returnTotalPriceForEachTier(int subscriptions, double unitPrice) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * unitPrice);
  }

  @ParameterizedTest
  @ValueSource(ints = {51, 1000})
  void returnTotalPriceForLastTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 149.0);
  }

  private static Stream<Arguments> tierRanges() {
    Stream<Arguments> firstTier  = FIRST_TIER_RANGE.mapToObj(i -> Arguments.of(i, 299.0));
    Stream<Arguments> secondTier = SECOND_TIER_RANGE.mapToObj(i -> Arguments.of(i, 239.0));
    Stream<Arguments> thirdTier  = THIRD_TIER_RANGE.mapToObj(i -> Arguments.of(i, 219.0));
    Stream<Arguments> fourthTier = FOURTH_TIER_RANGE.mapToObj(i -> Arguments.of(i, 199.0));
    return StreamEx.of(firstTier)
                   .append(secondTier)
                   .append(thirdTier)
                   .append(fourthTier);
  }
}
