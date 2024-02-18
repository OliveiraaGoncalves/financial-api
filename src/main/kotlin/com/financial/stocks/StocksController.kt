package com.financial.stocks

import com.financial.stocks.data.StockModel
import com.financial.stocks.data.StockRepository
import com.financial.stocks.domain.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StocksController @Autowired constructor(
    private val repository: StockRepository
) {

    @GetMapping("/allStocks")
    fun getStocksList(): ResponseEntity<List<StockModel>> {
        return repository.getAllStock()?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }

    @GetMapping( "/detailStock")
    fun getDetailStock(@RequestParam active: String): ResponseEntity<Stock> {
        return repository.getDetailStock(active)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }
}