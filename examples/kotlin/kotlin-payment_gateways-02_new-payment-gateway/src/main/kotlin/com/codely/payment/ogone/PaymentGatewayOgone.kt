package com.codely.payment.ogone

import com.codely.payment.*

class PaymentGatewayOgone(private val client: OgoneClient) : PaymentGateway {
    override fun createCustomer(customer: CustomerData): CustomerOgone {
        client.putCustomer(customer.customerId, customer.customerName)
        return CustomerOgone(customer.customerId, client)
    }

    override fun createCreditCard(card: CardData): CardOgone {
        return client.putCard(card.name, card.number)
    }

    override fun createPayment(amount: Number, customer: Customer, card: Card, order: Order?): PaymentOgone {
        val paymentId = client.putPayment(amount, customer.id, card.id)
        return PaymentOgone(paymentId)
    }

    override fun createOrder(): Order? {
        return null
    }
}