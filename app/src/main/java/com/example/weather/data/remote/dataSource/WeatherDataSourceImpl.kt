package com.example.weather.data.remote.dataSource

import com.example.weather.data.remote.dto.WeatherDto
import com.example.weather.domain.entity.LocationCoordinate
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class WeatherDataSourceImpl(
    private val client: HttpClient = HttpClient {
        install(ContentNegotiation) { json(Json{ ignoreUnknownKeys = true }) }
    }
    ):WeatherDataSource {


 override suspend fun getWeather(location:LocationCoordinate): WeatherDto {
     val url = "https://api.open-meteo.com/v1/forecast" +
             "?latitude=${location.latitude}" +
             "&longitude=${location.longitude}" +
             "&current_weather=true" +
             "&hourly=temperature_2m,weathercode,relativehumidity_2m,precipitation_probability,surface_pressure" +
             "&daily=temperature_2m_max,temperature_2m_min,weathercode,uv_index_max,apparent_temperature_max" +
             "&timezone=auto"

     val response: HttpResponse = client.get(url)
     return response.body<WeatherDto>()
    }

}