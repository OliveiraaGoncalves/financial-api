package com.financial.stocks

import com.financial.stocks.data.StockModel
import com.financial.stocks.data.StockRepository
import com.financial.stocks.domain.Quote
import com.financial.stocks.domain.Stock
import com.financial.stocks.domain.StockQuote
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.math.pow

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

    @GetMapping("/detailStock")
    fun getDetailStock(@RequestParam active: String): ResponseEntity<List<StockQuote>> {
        val listStockQuote = mutableListOf<StockQuote>()
        return repository.getDetailStock(active)?.let {
            it.chart?.result?.map { result ->
                result.timestamp?.forEachIndexed { index, timestamp ->
                    result.indicators?.quote?.map { quote ->
                        listStockQuote.add(
                            StockQuote(
                                timeStamp = timestamp,
                                open = formatPercentage(quote.open?.get(index), formatDecimal).toDouble(),
                                close = formatPercentage(quote.close?.get(index), formatDecimal).toDouble(),
                                high = formatPercentage(quote.high?.get(index), formatDecimal).toDouble(),
                                low = formatPercentage(quote.low?.get(index), formatDecimal).toDouble(),
                                volume = quote.volume?.get(index)
                            )
                        )
                    }
                }
            }

            listStockQuote.forEachIndexed { index, element ->
                val currentPrice = element.close ?: 0.0
                if (index > 0) {
                    val pricePrevious = listStockQuote[index - 1].close ?: 0.0
                    element.percentageVariation =
                        calculatePercentageVariation(currentPrice = currentPrice, pricePrevious = pricePrevious)
                } else {
                    element.percentageVariation = 0.0
                }

                val firstTradingDay = listStockQuote.first().close ?: 0.0
                element.percentageChangeSinceFirstTradingDay =
                    calculatePercentageVariation(currentPrice = firstTradingDay, pricePrevious = currentPrice)
            }
            ResponseEntity.ok(listStockQuote)
        } ?: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }

    fun calculatePercentageVariation(currentPrice: Double, pricePrevious: Double): Double {
        return formatPercentage(((currentPrice - pricePrevious) / pricePrevious) * 100, formatDecimalPercentage)
            .toDouble()
    }

    fun formatPercentage(percentage: Double?, decimalPlaces: Int): String {
        var truncatedValue = 0.0
        val multiplier = 10.0.pow(decimalPlaces.toDouble())
        percentage?.let {
            truncatedValue = (it * multiplier).toLong() / multiplier
        }
        return String.format(Locale.US, "%.${decimalPlaces}f", truncatedValue)
    }

    companion object {
        const val formatDecimal = 4
        const val formatDecimalPercentage = 2
    }
}