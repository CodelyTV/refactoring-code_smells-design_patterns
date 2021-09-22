package com.codely.payment

data class PaymentRequest(
    val amount: Number,
    val customer: CustomerData,
    val card: CardData
)
