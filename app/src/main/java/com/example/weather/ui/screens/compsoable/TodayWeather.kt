package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.zIndex
import com.example.weather.R
import com.example.weather.domain.entity.Weather
import com.example.weather.viewModel.WeatherViewModel

@Composable
fun TodayWeather(weather: Weather, weatherViewModel: WeatherViewModel){

    Row (
        Modifier.fillMaxWidth().height(168.dp),
        horizontalArrangement = Arrangement.End

    ){
        Column (
            horizontalAlignment = Alignment.End
        ){
            Text("Today",
                fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xFFFFFFFF),
                modifier = Modifier.padding(end = 12.dp, bottom = 24.dp)
            )
            LazyRow (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                reverseLayout = true
            ){

                    items(weather.hours.size){index->
                        Box (
                            modifier = Modifier.padding(end = 12.dp).width(88.dp)
                                .height(130.dp),

                            ){
                            Image(
                                painter = painterResource(weatherViewModel.fromWmoCodetoUiState(weather.weatherCodeHour[index],weather.isDay).iconRes),
                                contentDescription = "",
                                modifier = Modifier.size(64.dp).zIndex(1f).align(Alignment.TopCenter).offset(y = (-15).dp)
                            )
                            Box (
                                modifier = Modifier.width(88.dp)
                                    .height(120.dp)
                                    .align(Alignment.BottomCenter)
                                    .clip(RoundedCornerShape(20.dp))
                                    .border(width = 1.dp, Color(0x14FFFFFF), shape = RoundedCornerShape(20.dp))
                                    .background(Color(0xB2060414)),
                                contentAlignment = Alignment.Center

                            ){
                                Column(
                                    modifier = Modifier.padding(top = 50.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text("${weather.temperature2mInHour[index].toInt()}°C",
                                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                        fontWeight = FontWeight.W500,
                                        fontSize = 16.sp,
                                        letterSpacing = 0.25.sp,
                                        color = Color(0xDEFFFFFF),
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    Text(
                                        weather.hours[index],
                                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                        fontWeight = FontWeight.W500,
                                        fontSize = 16.sp,
                                        letterSpacing = 0.25.sp,
                                        color = Color(0x99FFFFFF)

                                    )
                                }
                            }
                        }
                    }
                }

            }
        }

}