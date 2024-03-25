package com.financial.sale.domain

data class Sale(
    val id: Long? = null,
    val clientName: String? = null,
    val productName: String? = null,
    val productAmount: String? = null,
    val productQuantity: String? = null,
    val hashSale: String? = null
)