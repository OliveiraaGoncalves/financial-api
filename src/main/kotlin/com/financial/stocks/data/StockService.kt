package com.financial.stocks.data

import com.financial.stocks.domain.Stock
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class StockService {
    private val webClient: RestTemplate = RestTemplate()
    val responseTypeStockModel = object : ParameterizedTypeReference<List<StockModel>>() {}

    fun getAllStock(): List<StockModel>? {
        val response: ResponseEntity<List<StockModel>> =
            webClient.exchange(baseURLAllStocks, HttpMethod.GET, null, responseTypeStockModel)

        return response.body as List<StockModel>
    }

    fun getDetailStock(active: String): Stock? {
        return webClient.getForObject(baseURLDetailStock.plus(active).plus("?interval=1d&range=1mo"), Stock::class.java)
    }

    companion object {
        private const val baseURLAllStocks =
            "https://financialmodelingprep.com/api/v3/stock/list?apikey=TpNwqJjfZX4aJVbzhrbbRUTSfIa96SQc"

        private const val baseURLDetailStock = "https://query2.finance.yahoo.com/v8/finance/chart/"
    }
}