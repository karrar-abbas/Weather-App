package com.example.weather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Daily(
    @SerialName("temperature_2m_max")
    val temperature2mMax: List<Double?>?,
    @SerialName("temperature_2m_min")
    val temperature2mMin: List<Double?>?,
    @SerialName("time")
    val time: List<String?>?,
    @SerialName("weathercode")
    val weathercode: List<Int?>?,
    @SerialName("uv_index_max")
    val uv_index_max: List<Double?>?,
    @SerialName("apparent_temperature_max")
    val apparent_temperature_max: List<Double?>?,
)

@Serializable
data class DailyUnits(
    @SerialName("temperature_2m_max")
    val temperature2mMax: String?,
    @SerialName("temperature_2m_min")
    val temperature2mMin: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("weathercode")
    val weathercode: String?,
    @SerialName("uv_index_max")
    val uv_index_max: String?,
    @SerialName("apparent_temperature_max")
    val apparent_temperature_max: String?
)
