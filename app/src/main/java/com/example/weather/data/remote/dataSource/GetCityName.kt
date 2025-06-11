package com.example.weather.data.remote.dataSource

import android.location.Location
import com.example.weather.domain.entity.LocationCoordinate

interface GetCityName {
    suspend fun getCitName(location: LocationCoordinate):String?
}