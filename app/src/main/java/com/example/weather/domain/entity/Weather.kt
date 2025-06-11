package com.example.weather.domain.entity

import kotlinx.serialization.SerialName

data class Weather(
    val city:String,
    //Current
    val isDay: Int,
    val temperature: Double,
    val weatherCodeCurrent: Int,
    val windSpeed: Double,

    //Week
    val temperature2mMax: List<Double>,
    val temperature2mMin: List<Double>,
    val day: List<String>,
    val weatherCodeWeek: List<Int>,
    val uvIndex: List<Double>,
    val apparent_temperature_max:List<Double>,

    //Hour
    val temperature2mInHour: List<Double>,
    val hours: List<String>,
    val weatherCodeHour: List<Int>,
    val relativehumidity_2m:List<Int>,
    val precipitation_probability:List<Int>,
    val surface_pressure:List<Double>,

)
