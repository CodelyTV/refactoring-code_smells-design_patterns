package com.codely.payment.stripe

import com.codely.payment.Card
import com.codely.payment.Customer

class CustomerStripe(override val id: String, private val client: StripeClient) : Customer {
    override fun assignCard(card: Card) {
        client.assignCardToCustomer(id, card.id)
    }
}