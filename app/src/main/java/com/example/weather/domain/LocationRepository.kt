package com.example.weather.domain

import com.example.weather.domain.entity.LocationCoordinate

interface LocationRepository {
    suspend fun getLocation():LocationCoordinate
}