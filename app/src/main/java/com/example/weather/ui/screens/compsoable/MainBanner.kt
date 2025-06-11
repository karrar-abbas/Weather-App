package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.viewModel.WeatherViewModel

@Composable
fun MainBanner(
    cityName:String,
    maxTemp:Double,
    minTemp:Double,
    temp:Double,
    weatherCode:Int,
    isDay:Int,
    weatherViewModel: WeatherViewModel
){
    val weatherUiSate=weatherViewModel.fromWmoCodetoUiState(weatherCode,isDay)
    Row {

        Text(cityName.toString(),
            fontFamily = FontFamily(Font(R.font.urbanist_medium)),
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(end = 4.dp)
        )
        Icon(
            painter = painterResource(R.drawable.location),
            contentDescription = "",
            tint = Color(0xFFFFFFFF)
        )
    }
    Image(
        painter = painterResource(weatherUiSate.iconRes),
        contentDescription = "",
        Modifier.size(250.dp).padding(top = 20.dp, bottom = 12.dp),
    )
    Text(
        "${temp.toInt()}°C",
        fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
        fontWeight = FontWeight.W600,
        fontSize = 64.sp,
        letterSpacing = 0.25.sp,
        color = Color(0xFFFFFFFF)
    )
    Text(weatherUiSate.description,
        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp,
        color = Color(0x99FFFFFF)
    )
    HightAndLowTempBox(maxTemp,minTemp)
}