package com.github.nuhkoca.data

import com.squareup.moshi.Json

data class Subscribe(
    @Json(name = "type") val type: String,
    @Json(name = "product_ids") val productIds: List<String>,
    @Json(name = "channels") val channels: List<String>
)
