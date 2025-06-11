package com.example.weather.data.remote.repository

import com.example.weather.data.remote.dataSource.GetCityName
import com.example.weather.domain.CityNameRepository
import com.example.weather.domain.entity.LocationCoordinate

class CityNameRepositoryImpl(
    private val cityName:GetCityName
):CityNameRepository {
    override suspend fun getCityName(location: LocationCoordinate): String? {
        return cityName.getCitName(location)
    }
}