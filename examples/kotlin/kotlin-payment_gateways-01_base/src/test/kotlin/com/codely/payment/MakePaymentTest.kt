package com.codely.payment

import com.codely.payment.adyen.AdyenClient
import com.codely.payment.adyen.PaymentGatewayAdyen
import com.codely.payment.ogone.OgoneClient
import com.codely.payment.ogone.PaymentGatewayOgone
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class MakePaymentTest {
    @Test
    fun `it should create a payment with Adyen`() {
        val gateway = PaymentGatewayAdyen(AdyenClient())
        val makePayment = MakePayment(gateway)
        val customer = CustomerData("customerId", "customerName")
        val card = CardData("cardName", "4242424242424242")
        val amount = 5
        val paymentRequest = PaymentRequest(amount,customer, card)
        makePayment.pay(paymentRequest)
    }

    @Test
    fun `it should create a payment with Ogone`() {
        val gateway = PaymentGatewayOgone(OgoneClient())
        val makePayment = MakePayment(gateway)
        val customer = CustomerData("customerId", "customerName")
        val card = CardData("cardName", "4242424242424242")
        val amount = 5
        val paymentRequest = PaymentRequest(amount,customer, card)
        makePayment.pay(paymentRequest)
    }
}
