package com.codely.payment.ogone

import com.codely.payment.Card
import com.codely.payment.Customer

class CustomerOgone(override val id: String, private val client: OgoneClient) : Customer {
    override fun assignCard(card: Card) {
        client.assignCardToCustomer(id, card.id)
    }
}