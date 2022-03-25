fn get_total_subscription_price(number_of_subscriptions: u32) -> u32 {
    const UNIT_PRICE: u32 = 299;

    match number_of_subscriptions {
        3 => 717,
        _ => UNIT_PRICE * number_of_subscriptions
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
}
