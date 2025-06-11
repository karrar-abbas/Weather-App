package com.example.weather.data.local.dataSource

import com.example.weather.data.local.dto.LocationCoordinateDTO

interface GetLocation {
    suspend fun getLocation(): LocationCoordinateDTO
}