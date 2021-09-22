package com.codely.payment

import com.codely.payment.ogone.OgoneClient
import com.codely.payment.ogone.PaymentGatewayOgone

class MakePayment(private val paymentGateway: PaymentGateway) {
    fun pay(paymentRequest: PaymentRequest) {
        val customer = paymentGateway.createCustomer(paymentRequest.customer)
        val card = paymentGateway.createCreditCard(paymentRequest.card)
        customer.assignCard(card)
        paymentGateway.createPayment(paymentRequest.amount, customer, card)
    }
}

fun main(args: Array<String>) {
    val ogoneGateway = PaymentGatewayOgone(OgoneClient())

    val payment = MakePayment(ogoneGateway)
    val customer = CustomerData("customerId", "customerName")
    val card = CardData("cardName", "4242424242424242")
    val amount = 5
    val paymentRequest = PaymentRequest(amount,customer, card)
    println(payment.pay(paymentRequest))
}
