package com.example.weather.ui.uiState

import androidx.annotation.DrawableRes

data class WeatherUiState(
    val description: String,
    @DrawableRes val iconRes: Int
)

