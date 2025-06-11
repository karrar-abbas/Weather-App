package com.example.weather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    @SerialName("interval")
    val interval: Int?,
    @SerialName("is_day")
    val isDay: Int?,
    @SerialName("temperature")
    val temperature: Double?,
    @SerialName("time")
    val time: String?,
    @SerialName("weathercode")
    val weathercode: Int?,
    @SerialName("winddirection")
    val winddirection: Int?,
    @SerialName("windspeed")
    val windspeed: Double?
)

@Serializable
data class CurrentWeatherUnits(
    @SerialName("interval")
    val interval: String?,
    @SerialName("is_day")
    val isDay: String?,
    @SerialName("temperature")
    val temperature: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("weathercode")
    val weathercode: String?,
    @SerialName("winddirection")
    val winddirection: String?,
    @SerialName("windspeed")
    val windspeed: String?
)