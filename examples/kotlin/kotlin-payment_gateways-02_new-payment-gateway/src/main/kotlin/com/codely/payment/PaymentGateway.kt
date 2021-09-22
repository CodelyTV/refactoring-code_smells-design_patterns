package com.codely.payment

interface PaymentGateway {
    fun createCustomer(customer: CustomerData): Customer
    fun createCreditCard(card: CardData): Card
    fun createPayment(amount: Number, customer: Customer, card: Card, order: Order?): Payment
    fun createOrder(): Order?
}