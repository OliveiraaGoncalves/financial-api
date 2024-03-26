package com.financial.sale.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository: JpaRepository<SaleModel, Long>{

    @Query("select a from SaleModel a where a.hashSale = ?1")
    fun findAllByHashSaleLike(hasSale: String): List<SaleModel>
}