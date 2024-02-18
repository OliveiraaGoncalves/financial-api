package com.financial.stocks.data

import com.financial.stocks.domain.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class StockRepository @Autowired constructor(
    private val stockService: StockService
) {
    fun getAllStock(): List<StockModel>? = stockService.getAllStock()

    fun getDetailStock(active: String): Stock? = stockService.getDetailStock(active)
}