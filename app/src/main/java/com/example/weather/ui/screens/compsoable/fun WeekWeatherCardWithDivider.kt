package com.example.weather.ui.screens.compsoable

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weather.R

@Composable
fun WeekWeatherCardWithDivider(today:String,high:Int,low:Int,icon:Painter){
    WeekWeatherCard(
        today = today, high = high, low = low,
        icon = icon
    )
    HorizontalDivider(thickness = 1.dp, color = Color(0x14FFFFFF))
}