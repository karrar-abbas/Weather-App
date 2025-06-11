package com.example.weather.domain

import com.example.weather.domain.entity.LocationCoordinate
import com.example.weather.domain.entity.Weather

class WeatherUseCase(
    private val locationRepo:LocationRepository,
    private val weatherRepository: WeatherRepository,
) {

    suspend fun getWeather():Weather{
        return weatherRepository.getWeather(locationRepo.getLocation())
    }
}