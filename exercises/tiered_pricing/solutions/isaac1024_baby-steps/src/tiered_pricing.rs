fn get_total_subscription_price(number_of_subscriptions: u32) -> u32 {
    const FIRST_UNIT_PRICE: u32 = 299;
    const SECOND_UNIT_PRICE: u32 = 239;

    match number_of_subscriptions {
        1|2 => FIRST_UNIT_PRICE * number_of_subscriptions,
        _ => SECOND_UNIT_PRICE * number_of_subscriptions
    }
}

#[cfg(test)]
mod tests {
    use crate::tiered_pricing::get_total_subscription_price;

    #[test]
    fn when_get_a_subscription_return_299_euros() {
        assert_eq!(299, get_total_subscription_price(1));
    }

    #[test]
    fn when_get_2_subscriptions_return_598_euros() {
        assert_eq!(598, get_total_subscription_price(2));
    }

    #[test]
    fn when_get_3_subscriptions_return_717_euros() {
        assert_eq!(717, get_total_subscription_price(3));
    }

    #[test]
    fn when_get_10_subscriptions_return_2390_euros() {
        assert_eq!(2390, get_total_subscription_price(10));
    }
}
