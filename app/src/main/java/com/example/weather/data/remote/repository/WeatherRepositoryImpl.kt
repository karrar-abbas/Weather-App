package com.example.weather.data.remote.repository

import com.example.weather.data.remote.dataSource.WeatherDataSource
import com.example.weather.domain.CityNameRepository
import com.example.weather.domain.WeatherRepository
import com.example.weather.domain.entity.LocationCoordinate
import com.example.weather.domain.entity.Weather
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class WeatherRepositoryImpl(
    private val dataSource:WeatherDataSource,
    private val cityNameRepository: CityNameRepository
):WeatherRepository {
    override suspend fun getWeather(location:LocationCoordinate): Weather {
        val weather=dataSource.getWeather(location)
        val cityName=cityNameRepository.getCityName(location)
        val dayHours=convertTimeToHour(weather.hourly?.time?.take(24))
        val weekDays=convertDateStringsToDayNames(weather.daily?.time)

        return Weather(
            city = cityName ?: "",
            isDay = weather.currentWeather?.isDay ?: 1,
            temperature = weather.currentWeather?.temperature ?: 0.0,
            weatherCodeCurrent = weather.currentWeather?.weathercode ?: 0,
            windSpeed = weather.currentWeather?.windspeed ?: 0.0,
            temperature2mMax = weather.daily?.temperature2mMax?.map { it ?: 0.0 }  ?: listOf(0.0),
            temperature2mMin =weather.daily?.temperature2mMin?.map { it ?: 0.0 }  ?: listOf(0.0),
            day = weekDays?.map { it ?: ""}  ?: listOf(""),
            weatherCodeWeek = weather.daily?.weathercode?.map { it ?: 0 }  ?: listOf(0),
            temperature2mInHour = weather.hourly?.temperature2m?.take(24)?.map { it ?: 0.0 }  ?: listOf(0.0),
            hours = dayHours?.map { it ?: "" }  ?: listOf(""),
            weatherCodeHour = weather.hourly?.weathercode?.take(24)?.map { it ?: 0 }  ?: listOf(0),
            relativehumidity_2m = weather.hourly?.relativehumidity_2m?.take(24)?.map { it ?: 0 } ?: listOf(0),
            precipitation_probability = weather.hourly?.precipitation_probability?.take(24)?.map { it ?: 0 } ?: listOf(0),
            uvIndex = weather.daily?.uv_index_max?.map { it ?: 0.0 } ?: listOf(0.0),
            surface_pressure = weather.hourly?.surface_pressure?.map { it ?: 0.0 } ?: listOf(0.0),
            apparent_temperature_max = weather.daily?.apparent_temperature_max?.map { it ?: 0.0 } ?: listOf(0.0)
        )
    }

    private fun convertTimeToHour(time:List<String?>?):List<String?>?{

        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val outputFormatter = DateTimeFormatter.ofPattern("h:mm")

        return time?.map {
            LocalDateTime.parse(it, inputFormatter).format(outputFormatter)
        }

    }

    private fun convertDateStringsToDayNames(dateStrings: List<String?>?): List<String?>? {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern("EEEE", Locale("en"))

        return dateStrings?.mapNotNull { dateString ->
            try {
                val date = LocalDate.parse(dateString, inputFormatter)
                date.format(outputFormatter)
            } catch (e: Exception) {
                null
            }
        }
    }
}