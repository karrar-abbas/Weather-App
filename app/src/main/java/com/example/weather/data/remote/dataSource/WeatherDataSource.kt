package com.example.weather.data.remote.dataSource

import com.example.weather.data.remote.dto.WeatherDto
import com.example.weather.domain.entity.LocationCoordinate

interface WeatherDataSource {
    suspend fun getWeather(location:LocationCoordinate): WeatherDto
}