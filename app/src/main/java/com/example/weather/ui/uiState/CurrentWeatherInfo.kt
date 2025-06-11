package com.example.weather.ui.uiState

import androidx.compose.ui.res.painterResource
import com.example.weather.R

data class CurrentWeatherInfo(
    val icon:Int,
    val unit:String,
    val value:Int,
    val weatherElement:String
)
