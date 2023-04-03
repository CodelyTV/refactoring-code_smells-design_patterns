export default class NumberOfSubscriptionsNotAllowed extends Error {
  constructor() {
    super("Number of subscriptions not allowed");
  }
}
