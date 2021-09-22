package com.codely.payment

interface Customer {
    val id: String
    fun assignCard(card: Card)
}