package com.financial.sale.data

import jakarta.persistence.*


@Entity
@Table(name = "sale")
data class SaleModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "client_name")
    val clientName: String? = null,

    @Column(name = "product_name")
    val productName: String? = null,

    @Column(name = "product_amount")
    val productAmount: String? = null,

    @Column(name = "product_quantity")
    val productQuantity: String? = null,

    @Column(name = "hash_sale")
    val hashSale: String? = null
)