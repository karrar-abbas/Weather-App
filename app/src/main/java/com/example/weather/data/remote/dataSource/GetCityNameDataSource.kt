package com.example.weather.data.remote.dataSource

import android.content.Context
import android.location.Geocoder
import com.example.weather.domain.entity.LocationCoordinate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale

class GetCityNameDataSource(private val context: Context):GetCityName {

    override suspend fun getCitName(location: LocationCoordinate): String? {
        return withContext(Dispatchers.IO) {
            try {
                val geocoder = Geocoder(context, Locale.ENGLISH)
                val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                if (addresses != null && addresses.isNotEmpty()) {
                    addresses[0].adminArea.replace("Governorate", "").trim()
                } else {
                    null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }



}