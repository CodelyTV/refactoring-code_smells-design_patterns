import NumberOfSubscriptionsNotAllowed from "./NumberOfSubscriptionsNotAllowed";

export default class GraduatedTieredPricing {
  priceFor(subscriptions: number): number {
    if (subscriptions < 1) {
      throw new NumberOfSubscriptionsNotAllowed();
    }

    const step1Price = 299;
    const step2Price = 239;
    const step3Price = 219;
    const step4Price = 199;
    const step5Price = 149;

    const step1Boundary = 2;
    const step2Boundary = 10;
    const step3Boundary = 25;
    const step4Boundary = 50;

    const numberOfSubscriptionsInStep1 = 2;
    const numberOfSubscriptionsInStep2 = step2Boundary - step1Boundary; // 8
    const numberOfSubscriptionsInStep3 = step3Boundary - step2Boundary; // 15
    const numberOfSubscriptionsInStep4 = step4Boundary - step3Boundary; // 25

    if (subscriptions <= step1Boundary) {
      return subscriptions * step1Price;
    }
    if (subscriptions <= step2Boundary) {
      return (
        numberOfSubscriptionsInStep1 * step1Price +
        (subscriptions - numberOfSubscriptionsInStep1) * step2Price
      );
    }
    if (subscriptions <= step3Boundary) {
      return (
        numberOfSubscriptionsInStep1 * step1Price +
        numberOfSubscriptionsInStep2 * step2Price +
        (subscriptions -
          (numberOfSubscriptionsInStep1 + numberOfSubscriptionsInStep2)) *
          step3Price
      );
    }
    if (subscriptions <= step4Boundary) {
      return (
        numberOfSubscriptionsInStep1 * step1Price +
        numberOfSubscriptionsInStep2 * step2Price +
        numberOfSubscriptionsInStep3 * step3Price +
        (subscriptions -
          (numberOfSubscriptionsInStep1 +
            numberOfSubscriptionsInStep2 +
            numberOfSubscriptionsInStep3)) *
          step4Price
      );
    }
    return (
      numberOfSubscriptionsInStep1 * step1Price +
      numberOfSubscriptionsInStep2 * step2Price +
      numberOfSubscriptionsInStep3 * step3Price +
      numberOfSubscriptionsInStep4 * step4Price +
      (subscriptions -
        (numberOfSubscriptionsInStep1 +
          numberOfSubscriptionsInStep2 +
          numberOfSubscriptionsInStep3 +
          numberOfSubscriptionsInStep4)) *
        step5Price
    );
  }
}
