package com.github.nuhkoca.data

import com.squareup.moshi.Json

data class TickerRequest(
    val name: String = "ticker",
    @Json(name = "product_ids") val productIds: List<String>
)
