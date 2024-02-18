package com.financial.stocks.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Stock(
    @JsonProperty("chart") val chart: Chart,
)

data class Chart(
    @JsonProperty("result") val result: List<Result>,
    @JsonProperty("error") val error: Any?,
)

data class Result(
    @JsonProperty("meta") val meta: Meta,
    @JsonProperty("timestamp") val timestamp: List<Long>,
    @JsonProperty("indicators") val indicators: Indicators,
)

data class Meta(
    @JsonProperty("currency") val currency: String,
    @JsonProperty("symbol") val symbol: String,
    @JsonProperty("exchangeName") val exchangeName: String,
    @JsonProperty("instrumentType") val instrumentType: String,
    @JsonProperty("firstTradeDate") val firstTradeDate: Long,
    @JsonProperty("regularMarketTime") val regularMarketTime: Long,
    @JsonProperty("gmtoffset") val gmtoffset: Long,
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("exchangeTimezoneName") val exchangeTimezoneName: String,
    @JsonProperty("regularMarketPrice") val regularMarketPrice: Double,
    @JsonProperty("chartPreviousClose") val chartPreviousClose: Long,
    @JsonProperty("priceHint") val priceHint: Long,
    @JsonProperty("currentTradingPeriod") val currentTradingPeriod: CurrentTradingPeriod,
    @JsonProperty("dataGranularity") val dataGranularity: String,
    @JsonProperty("range") val range: String,
    @JsonProperty("validRanges") val validRanges: List<String>,
)

data class CurrentTradingPeriod(
    @JsonProperty("pre") val pre: Pre,
    @JsonProperty("regular") val regular: Regular,
    @JsonProperty("post") val post: Post,
)

data class Pre(
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("end") val end: Long,
    @JsonProperty("start") val start: Long,
    @JsonProperty("gmtoffset") val gmtoffset: Long,
)

data class Regular(
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("end") val end: Long,
    @JsonProperty("start") val start: Long,
    @JsonProperty("gmtoffset") val gmtoffset: Long,
)

data class Post(
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("end") val end: Long,
    @JsonProperty("start") val start: Long,
    @JsonProperty("gmtoffset") val gmtoffset: Long,
)

data class Indicators(
    @JsonProperty("quote") val quote: List<Quote>,
    @JsonProperty("adjclose") val adjclose: List<Adjclose>,
)

data class Quote(
    @JsonProperty("open") val open: List<Double>,
    @JsonProperty("close") val close: List<Double>,
    @JsonProperty("volume") val volume: List<Long>,
    @JsonProperty("high") val high: List<Double>,
    @JsonProperty("low") val low: List<Double>,
)

data class Adjclose(
    @JsonProperty("adjclose") val adjclose: List<Double>,
)