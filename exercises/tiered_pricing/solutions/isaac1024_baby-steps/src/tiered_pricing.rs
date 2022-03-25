fn get_total_subscription_price(number_of_subscriptions: u32) -> Result<u32, String> {
    const FIRST_UNIT_PRICE: u32 = 299;
    const SECOND_UNIT_PRICE: u32 = 239;
    const THIRD_UNIT_PRICE: u32 = 219;
    const FOURTH_UNIT_PRICE: u32 = 199;
    const FIFTH_UNIT_PRICE: u32 = 149;

    match number_of_subscriptions {
        0 => Err("Error".to_string()),
        1|2 => Ok(FIRST_UNIT_PRICE * number_of_subscriptions),
        3..=10 => Ok(SECOND_UNIT_PRICE * number_of_subscriptions),
        11..=25 => Ok(THIRD_UNIT_PRICE * number_of_subscriptions),
        26..=50 => Ok(FOURTH_UNIT_PRICE * number_of_subscriptions),
        _ => Ok(FIFTH_UNIT_PRICE * number_of_subscriptions),
    }
}

#[cfg(test)]
mod tests {
    use crate::tiered_pricing::get_total_subscription_price;

    #[test]
    fn when_get_a_subscription_return_299_euros() -> Result<(), String> {
        assert_eq!(299, get_total_subscription_price(1)?);
        Ok(())
    }

    #[test]
    fn when_get_2_subscriptions_return_598_euros() -> Result<(), String> {
        assert_eq!(598, get_total_subscription_price(2)?);
        Ok(())
    }

    #[test]
    fn when_get_3_subscriptions_return_717_euros() -> Result<(), String> {
        assert_eq!(717, get_total_subscription_price(3)?);
        Ok(())
    }

    #[test]
    fn when_get_10_subscriptions_return_2390_euros() -> Result<(), String> {
        assert_eq!(2390, get_total_subscription_price(10)?);
        Ok(())
    }

    #[test]
    fn when_get_11_subscriptions_return_2409_euros() -> Result<(), String> {
        assert_eq!(2409, get_total_subscription_price(11)?);
        Ok(())
    }

    #[test]
    fn when_get_25_subscriptions_return_5475_euros() -> Result<(), String> {
        assert_eq!(5475, get_total_subscription_price(25)?);
        Ok(())
    }

    #[test]
    fn when_get_26_subscriptions_return_5174_euros() -> Result<(), String> {
        assert_eq!(5174, get_total_subscription_price(26)?);
        Ok(())
    }

    #[test]
    fn when_get_50_subscriptions_return_9950_euros() -> Result<(), String> {
        assert_eq!(9950, get_total_subscription_price(50)?);
        Ok(())
    }

    #[test]
    fn when_get_51_subscriptions_return_7599_euros() -> Result<(), String> {
        assert_eq!(7599, get_total_subscription_price(51)?);
        Ok(())
    }

    #[test]
    fn when_get_52_subscriptions_return_7748_euros() -> Result<(), String> {
        assert_eq!(7748, get_total_subscription_price(52)?);
        Ok(())
    }

    #[test]
    fn when_get_0_subscriptions_return_error() {
        assert!(get_total_subscription_price(0).is_err());
    }
}
