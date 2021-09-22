package com.codely.payment.adyen

import com.codely.payment.Card
import com.codely.payment.Customer

class CustomerAdyen(override val id: String, private val client: AdyenClient) : Customer {
    override fun assignCard(card: Card) {
        client.assignCardToCustomer(id, card.id)
    }
}