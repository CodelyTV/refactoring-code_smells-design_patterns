package com.codely.payment.adyen

import com.codely.payment.*

class PaymentGatewayAdyen(private val client: AdyenClient) : PaymentGateway {
    override fun createCustomer(customer: CustomerData): CustomerAdyen {
        val customerId = client.putCustomer(customer.customerName)
        return CustomerAdyen(customerId, client)
    }

    override fun createCreditCard(card: CardData): CardAdyen {
        return client.putCard(card.name, card.number)
    }

    override fun createPayment(amount: Number, customer: Customer, card: Card): PaymentAdyen {
        val paymentId = client.putPayment(amount, customer.id, card.id)
        return PaymentAdyen(paymentId)
    }
}