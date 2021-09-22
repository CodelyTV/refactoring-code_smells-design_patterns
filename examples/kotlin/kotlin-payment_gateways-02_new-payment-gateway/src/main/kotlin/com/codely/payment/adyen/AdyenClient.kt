package com.codely.payment.adyen

class AdyenClient {
    fun putCustomer(name: String): String {
        println("PUT /adyen/customer HTTP/1.1")
        return "CustomerId"
    }

    fun putCard(name: String, number: String): CardAdyen {
        println("PUT /adyen/card HTTP/1.1")
        return CardAdyen("cardId")
    }

    fun assignCardToCustomer(customerId: String, cardId: String) {
        println("PUT /adyen/assign-card HTTP/1.1")
    }

    fun putPayment(amount: Number, customerId: String, cardId: String): String {
        println("PUT /adyen/payment HTTP/1.1")
        return "paymentId"
    }
}