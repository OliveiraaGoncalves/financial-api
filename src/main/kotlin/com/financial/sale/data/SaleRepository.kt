package com.financial.sale.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository: JpaRepository<SaleModel, Long>