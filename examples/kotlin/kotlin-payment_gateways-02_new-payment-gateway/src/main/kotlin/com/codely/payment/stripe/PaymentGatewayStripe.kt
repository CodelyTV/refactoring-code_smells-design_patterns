package com.codely.payment.stripe

import com.codely.payment.*

class PaymentGatewayStripe(private val client: StripeClient) : PaymentGateway {
    override fun createCustomer(customer: CustomerData): CustomerStripe {
        client.putCustomer(customer.customerId, customer.customerName)
        return CustomerStripe(customer.customerId, client)
    }

    override fun createCreditCard(card: CardData): CardStripe {
        return client.putCard(card.name, card.number)
    }

    override fun createPayment(amount: Number, customer: Customer, card: Card, order: Order?): PaymentStripe {
        if (order === null) {
            throw Exception("Order cannot be null")
        }
        val paymentId = client.putPayment(amount, customer.id, card.id, order.id)
        return PaymentStripe(paymentId)
    }

    override fun createOrder(): Order {
        return OrderStripe("orderId")
    }
}