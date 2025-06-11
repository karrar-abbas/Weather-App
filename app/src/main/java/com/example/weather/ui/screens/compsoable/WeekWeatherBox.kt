package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.domain.entity.Weather
import com.example.weather.viewModel.WeatherViewModel

@Composable
fun WeekWeatherBox(weather: Weather, weatherViewModel: WeatherViewModel){
    Column (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.End
    ){
        Text("Next 7 days",
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
        )
        Box (
            modifier = Modifier.height(435.dp).fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .border(width =1.dp, color = Color(0x14FFFFFF), shape = RoundedCornerShape(24.dp))
                .background(Color(0xB2060414))
        ){
            Column(modifier = Modifier.fillMaxSize()) {
                weather.day.forEachIndexed{index,it,->
                    WeekWeatherCardWithDivider(
                        today = it, high = weather.temperature2mMax[index].toInt(), low = weather.temperature2mMin[index].toInt(),
                        icon = painterResource(weatherViewModel.fromWmoCodetoUiState(weather.weatherCodeWeek[index],weather.isDay).iconRes)
                    )
                }

            }

        }
    }
}