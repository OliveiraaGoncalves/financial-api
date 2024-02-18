package com.financial.stocks.data

import com.fasterxml.jackson.annotation.JsonProperty

data class StockModel(
    @JsonProperty("symbol") val symbol: String,
    @JsonProperty("name") val name: String?,
    @JsonProperty("price") val price: Double,
    @JsonProperty("exchange") val exchange: String?,
    @JsonProperty("exchangeShortName") val exchangeShortName: String?,
    @JsonProperty("type") val type: String,
)
typealias allStocks = List<StockModel>;