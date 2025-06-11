package com.example.weather.data.local.repository

import com.example.weather.data.local.dataSource.GetLocation
import com.example.weather.domain.LocationRepository
import com.example.weather.domain.entity.LocationCoordinate

class LocationRepositoryImpl(private val locationDatSource:GetLocation):LocationRepository {
    override suspend fun getLocation(): LocationCoordinate {
        return LocationCoordinate(
            latitude = locationDatSource.getLocation().latitude,
            longitude = locationDatSource.getLocation().longitude
        )
    }
}