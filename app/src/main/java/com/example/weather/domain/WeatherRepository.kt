package com.example.weather.domain

import com.example.weather.domain.entity.LocationCoordinate
import com.example.weather.domain.entity.Weather

interface WeatherRepository {
    suspend fun getWeather(location:LocationCoordinate):Weather
}