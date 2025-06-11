package com.example.weather.domain

import com.example.weather.domain.entity.LocationCoordinate

interface CityNameRepository {
    suspend fun getCityName(location:LocationCoordinate):String?
}