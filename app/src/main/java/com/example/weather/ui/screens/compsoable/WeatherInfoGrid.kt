package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.domain.entity.Weather
import com.example.weather.ui.uiState.CurrentWeatherInfo

@Composable
fun WeatherInfoGrid(weatherElements:List<CurrentWeatherInfo>){

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
        .padding(top = 24.dp, start = 12.dp, end = 12.dp, bottom = 24.dp)
            .fillMaxWidth()
            .height(236.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        userScrollEnabled = false,
    ) {

        itemsIndexed(weatherElements){index,item ->
            WeatherCard(
                icon = painterResource(item.icon),
                unit = item.unit,
                value =item.value,
                weatherElement = item.weatherElement
            )
        }


    }
}