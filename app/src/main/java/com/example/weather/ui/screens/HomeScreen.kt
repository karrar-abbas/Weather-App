package com.example.weather.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.domain.entity.LocationCoordinate
import com.example.weather.domain.entity.Weather
import com.example.weather.ui.screens.compsoable.MainBanner
import com.example.weather.ui.screens.compsoable.TodayWeather
import com.example.weather.ui.screens.compsoable.WeatherInfoGrid
import com.example.weather.ui.screens.compsoable.WeekWeatherBox
import com.example.weather.ui.uiState.CurrentWeatherInfo
import com.example.weather.viewModel.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(weatherViewModel: WeatherViewModel= koinViewModel()){
    val weather by weatherViewModel.weatherState.collectAsState()
    RequestLocationPermission {
        weatherViewModel.getWeather()
    }
    val weatherElements=weatherViewModel.getWeatherElements(weather)
    HomeScreenContent(weather,weatherViewModel,weatherElements)
}
@Composable
private fun HomeScreenContent(weather:Weather,weatherViewModel: WeatherViewModel,weatherElements:List<CurrentWeatherInfo>){
    LazyColumn (
        modifier = Modifier.fillMaxSize()
            .background(Brush.linearGradient(colors = listOf(Color(0xFF060414), Color(0xFF0D0C19))))
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 100.dp)
    ){
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 24.dp)) {
                MainBanner(
                    cityName = weather.city,
                    maxTemp = weather.temperature2mMax[0],
                    minTemp = weather.temperature2mMin[0],
                    temp = weather.temperature,
                    weatherCode=weather.weatherCodeCurrent,
                    isDay = weather.isDay,
                    weatherViewModel
                )
                WeatherInfoGrid(weatherElements)
                TodayWeather(
                    weather,
                    weatherViewModel
                )
                WeekWeatherBox(
                    weather,
                    weatherViewModel
                )
            }
        }
    }
}