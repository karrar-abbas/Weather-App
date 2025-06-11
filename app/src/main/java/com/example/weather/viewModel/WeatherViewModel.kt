package com.example.weather.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.domain.WeatherUseCase
import com.example.weather.domain.entity.LocationCoordinate
import com.example.weather.domain.entity.Weather
import com.example.weather.ui.uiState.CurrentWeatherInfo
import com.example.weather.ui.uiState.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weather:WeatherUseCase
):ViewModel() {
    private val _weatherState= MutableStateFlow<Weather>(Weather(
        city = "",
        isDay = 0,
        temperature = 0.0,
        weatherCodeCurrent = 0,
        windSpeed = 0.0,
        temperature2mMax = listOf(0.0),
        temperature2mMin = listOf(0.0),
        day = listOf(""),
        weatherCodeWeek = listOf(0),
        temperature2mInHour = listOf(0.0),
        hours = listOf(""),
        weatherCodeHour = listOf(0),
        relativehumidity_2m = listOf(0) ,
        surface_pressure = listOf(0.0) ,
        uvIndex = listOf(0.0),
        precipitation_probability = listOf(0),
        apparent_temperature_max = listOf(0.0)
    ))
    val weatherState=_weatherState.asStateFlow()


    fun getWeather(){
        viewModelScope.launch {
            _weatherState.update { weather.getWeather() }

        }
    }

    fun fromWmoCodetoUiState(code: Int,isDay:Int): WeatherUiState{
        if(isDay==0) {
           return when (code) {
               0 -> WeatherUiState("Clear sky", R.drawable.night_clear_sky)
               1 -> WeatherUiState("Mainly clear", R.drawable.night_mainly_clear)
               2 -> WeatherUiState("Partly cloudy", R.drawable.night_partly_cloudy)
               3 -> WeatherUiState("Overcast", R.drawable.night_overcast)
               45 -> WeatherUiState("Fog", R.drawable.night_fog)
               48 -> WeatherUiState("Depositing rime fog", R.drawable.night_depositing_rime_fog)
               51 -> WeatherUiState("Light drizzle", R.drawable.night_drizzle_light)
               53 -> WeatherUiState("Moderate drizzle", R.drawable.night_drizzle_moderate)
               55 -> WeatherUiState("Dense drizzle", R.drawable.night_drizzle_intensity)
               56 -> WeatherUiState("Light freezing drizzle", R.drawable.night_freezing_drizzle_light)
               57 -> WeatherUiState("Dense freezing drizzle", R.drawable.night_freezing_drizzle_intensity)
               61 -> WeatherUiState("Slight rain", R.drawable.night_rain_slight)
               63 -> WeatherUiState("Moderate rain", R.drawable.night_rain_moderate)
               65 -> WeatherUiState("Heavy rain", R.drawable.night_rain_intensity)
               66 -> WeatherUiState("Light freezing rain", R.drawable.night_freezing_light)
               67 -> WeatherUiState("Heavy freezing rain", R.drawable.night_freezing_heavy)
               71 -> WeatherUiState("Slight snowfall", R.drawable.night_snow_fall_light)
               73 -> WeatherUiState("Moderate snowfall", R.drawable.night_snow_fall_moderate)
               75 -> WeatherUiState("Heavy snowfall", R.drawable.night_snow_fall_intensity)
               77 -> WeatherUiState("Snow grains", R.drawable.night_snow_grains)
               80 -> WeatherUiState("Slight rain showers", R.drawable.night_rain_shower_slight)
               81 -> WeatherUiState("Moderate rain showers", R.drawable.night_rain_shower_moderate)
               82 -> WeatherUiState("Violent rain showers", R.drawable.night_rain_shower_violent)
               85 -> WeatherUiState("Slight snow showers", R.drawable.night_snow_shower_slight)
               86 -> WeatherUiState("Heavy snow showers", R.drawable.night_snow_shower_heavy)
               95 -> WeatherUiState("Thunderstorm", R.drawable.night_thunderstrom_slight_or_moderate)
               96 -> WeatherUiState("Thunderstorm with slight hail", R.drawable.night_thunderstrom_with_slight_hail)
               99 -> WeatherUiState("Thunderstorm with heavy hail", R.drawable.night_thunderstrom_with_heavy_hail)
               else -> WeatherUiState("Unknown weather", R.drawable.day_clear_sky)
           }
       }else{
            return when (code) {
                0 -> WeatherUiState("Clear sky", R.drawable.day_clear_sky)
                1 -> WeatherUiState("Mainly clear", R.drawable.day_weather_icon)
                2 -> WeatherUiState("Partly cloudy", R.drawable.day_partly_cloudy)
                3 -> WeatherUiState("Overcast", R.drawable.day_overcast)
                45 -> WeatherUiState("Fog", R.drawable.day_fog)
                48 -> WeatherUiState("Depositing rime fog", R.drawable.day_depositing_rime_fog)
                51 -> WeatherUiState("Light drizzle", R.drawable.day_drizzle_light)
                53 -> WeatherUiState("Moderate drizzle", R.drawable.day_drizzle_moderate)
                55 -> WeatherUiState("Dense drizzle", R.drawable.day_drizzle_intensity)
                56 -> WeatherUiState("Light freezing drizzle", R.drawable.day_freezing_drizzle_light)
                57 -> WeatherUiState("Dense freezing drizzle", R.drawable.day_freezing_drizzle_intensity)
                61 -> WeatherUiState("Slight rain", R.drawable.day_rain_slight)
                63 -> WeatherUiState("Moderate rain", R.drawable.day_rain_moderate)
                65 -> WeatherUiState("Heavy rain", R.drawable.day_rain_intensity)
                66 -> WeatherUiState("Light freezing rain", R.drawable.day_freezing_loght)
                67 -> WeatherUiState("Heavy freezing rain", R.drawable.day_freezing_heavy)
                71 -> WeatherUiState("Slight snowfall", R.drawable.day_snow_fall_light)
                73 -> WeatherUiState("Moderate snowfall", R.drawable.day_snow_fall_moderate)
                75 -> WeatherUiState("Heavy snowfall", R.drawable.day_snow_fall_intensity)
                77 -> WeatherUiState("Snow grains", R.drawable.day_snow_grains)
                80 -> WeatherUiState("Slight rain showers", R.drawable.day_rain_shower_slight)
                81 -> WeatherUiState("Moderate rain showers", R.drawable.day_rain_shower_moderate)
                82 -> WeatherUiState("Violent rain showers", R.drawable.day_rain_shower_violent)
                85 -> WeatherUiState("Slight snow showers", R.drawable.day_snow_shower_slight)
                86 -> WeatherUiState("Heavy snow showers", R.drawable.day_snow_shower_heavy)
                95 -> WeatherUiState("Thunderstorm", R.drawable.day_thunderstrom_slight_or_moderate)
                96 -> WeatherUiState("Thunderstorm with slight hail", R.drawable.day_thunderstrom_with_slight_hail)
                99 -> WeatherUiState("Thunderstorm with heavy hail", R.drawable.day_thunderstrom_with_heavy_hail)
                else -> WeatherUiState("Unknown weather", R.drawable.day_clear_sky)
            }
        }

    }

    fun getWeatherElements(weather: Weather):List<CurrentWeatherInfo>{
        return listOf(
            CurrentWeatherInfo(
                icon = R.drawable.rain,
                unit = "%",
                value = weather.precipitation_probability[0],
                weatherElement = "Rain"
            ),
            CurrentWeatherInfo(
                icon = R.drawable.humidity,
                unit = "%",
                value = weather.relativehumidity_2m[0],
                weatherElement = "Humidity"
            ),
            CurrentWeatherInfo(
                icon = R.drawable.fast_wind,
                unit = "KM/H",
                value = weather.windSpeed.toInt(),
                weatherElement = "Wind"
            ),
            CurrentWeatherInfo(
                icon = R.drawable.temperature,
                unit = "°C",
                value = weather.apparent_temperature_max[0].toInt(),
                weatherElement = "Feels like"
            ),
            CurrentWeatherInfo(
                icon = R.drawable.pressure,
                unit = "hPa",
                value = weather.surface_pressure[0].toInt(),
                weatherElement = "Pressure"
            ),

            CurrentWeatherInfo(
                icon = R.drawable.uv_02,
                unit = "",
                value = weather.uvIndex[0].toInt(),
                weatherElement = "UV Index"
            ),
        )
    }
}