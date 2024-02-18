package com.financial.stocks.domain

data class StockQuote(
    val timeStamp: Long,
    val open: Double?,
    val close: Double?,
    val volume: Long?,
    val high: Double?,
    val low: Double?,
    var percentageVariation: Double? = 0.0
)