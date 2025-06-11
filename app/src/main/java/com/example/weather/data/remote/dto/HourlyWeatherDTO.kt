package com.example.weather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Hourly(
    @SerialName("temperature_2m")
    val temperature2m: List<Double?>?,
    @SerialName("time")
    val time: List<String?>?,
    @SerialName("weathercode")
    val weathercode: List<Int?>?,
    @SerialName("relativehumidity_2m")
    val relativehumidity_2m: List<Int?>?,
    @SerialName("precipitation_probability")
    val precipitation_probability: List<Int?>?,
    @SerialName("surface_pressure")
    val surface_pressure: List<Double?>?

)

@Serializable
data class HourlyUnits(
    @SerialName("temperature_2m")
    val temperature2m: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("weathercode")
    val weathercode: String?,
    @SerialName("relativehumidity_2m")
    val relativehumidity_2m: String?,
    @SerialName("precipitation_probability")
    val precipitation_probability: String?,
    @SerialName("surface_pressure")
    val surface_pressure: String?
)
