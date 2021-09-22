package com.codely.payment.stripe

class StripeClient {
    fun putCustomer(id: String, name: String) {
        println("PUT /stripe/customer HTTP/1.1")
    }

    fun putCard(name: String, number: String): CardStripe {
        println("PUT /stripe/card HTTP/1.1")
        return CardStripe("cardId")
    }

    fun assignCardToCustomer(customerId: String, cardId: String) {
        println("PUT /stripe/assign-card HTTP/1.1")
    }

    fun putPayment(amount: Number, customerId: String, cardId: String, orderId: String): String {
        println("PUT /stripe/payment HTTP/1.1")
        return "paymentId"
    }
}