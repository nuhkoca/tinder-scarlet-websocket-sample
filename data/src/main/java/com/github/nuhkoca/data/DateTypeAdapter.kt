package com.github.nuhkoca.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateTypeAdapter : JsonAdapter<Date>() {

    private val serverFormatter = SimpleDateFormat(SERVER_DATE_FORMAT, Locale.getDefault())
    private val appFormatter = SimpleDateFormat(APP_DATE_FORMAT, Locale.getDefault())

    @FromJson
    override fun fromJson(reader: JsonReader): Date? {
        return try {
            val dateAsString = reader.nextString()
            serverFormatter.parse(dateAsString)
        } catch (e: Exception) {
            null
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Date?) {
        value?.let { writer.value(appFormatter.format(it)) }
    }

    companion object {
        private const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.ssZ"
        private const val APP_DATE_FORMAT = "yyyy-MM-dd"
    }
}
