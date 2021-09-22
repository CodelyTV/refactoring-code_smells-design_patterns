package com.codely.payment.ogone

class OgoneClient {
    fun putCustomer(id: String, name: String) {
        println("PUT /ogone/customer HTTP/1.1")
    }

    fun putCard(name: String, number: String): CardOgone {
        println("PUT /ogone/card HTTP/1.1")
        return CardOgone("cardId")
    }

    fun assignCardToCustomer(customerId: String, cardId: String) {
        println("PUT /ogone/assign-card HTTP/1.1")
    }

    fun putPayment(amount: Number, customerId: String, cardId: String): String {
        println("PUT /ogone/payment HTTP/1.1")
        return "paymentId"
    }
}