package tv.codely.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TieredPricingShould {

  private TieredPricing tieredPricing;

  @BeforeEach
  void setUp() {
    tieredPricing = new TieredPricing();
  }

  @ParameterizedTest
  @MethodSource("rangeFirstTier")
  void returnTotalPriceForFirstTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 299.0);
  }

  @ParameterizedTest
  @MethodSource("rangeSecondTier")
  void returnTotalPriceForSecondTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 239.0);
  }

  @ParameterizedTest
  @MethodSource("rangeThirdTier")
  void returnTotalPriceForThirdTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 219.0);
  }

  @ParameterizedTest
  @MethodSource("rangeFourthTier")
  void returnTotalPriceForFourthTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 199.0);
  }

  @ParameterizedTest
  @ValueSource(ints = {51, 1000})
  void returnTotalPriceForLastTier(int subscriptions) {
    double totalPrice = tieredPricing.totalPrice(subscriptions);

    assertThat(totalPrice).isEqualTo(subscriptions * 149.0);
  }

  private static Stream<Integer> rangeFirstTier() {
    return IntStream.rangeClosed(1, 2).boxed();
  }

  private static Stream<Integer> rangeSecondTier() {
    return IntStream.rangeClosed(3, 10).boxed();
  }

  private static Stream<Integer> rangeThirdTier() {
    return IntStream.rangeClosed(11, 25).boxed();
  }

  private static Stream<Integer> rangeFourthTier() {
    return IntStream.rangeClosed(26, 50).boxed();
  }
}
