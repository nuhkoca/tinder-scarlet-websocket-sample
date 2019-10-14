package com.github.nuhkoca.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.squareup.moshi.Json
import java.util.Date

data class Ticker(
    @Json(name = "time")
    @JsonInclude(Include.NON_NULL)
    val time: Date,
    @Json(name = "price")
    @JsonInclude(Include.NON_NULL)
    val price: String
)
