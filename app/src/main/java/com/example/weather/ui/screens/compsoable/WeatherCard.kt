package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R

@Composable
fun WeatherCard(icon:Painter,unit:String,value:Int,weatherElement:String){
    Box (
        Modifier.fillMaxWidth().height(115.dp)
            .clip(RoundedCornerShape(24.dp))
            .border(width = 1.dp, Color(0x14FFFFFF), shape = RoundedCornerShape(24.dp))
            .background(Color(0xB2060414))
            .padding(vertical = 16.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ){
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = icon,
                contentDescription = "",
                tint = Color(0xFF87CEFA),
                modifier = Modifier.size(32.dp)
            )
            Row {
                Text(unit,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    color = Color(0xDEFFFFFF),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(value.toString(),
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp,
                    letterSpacing = 0.25.sp,
                    color = Color(0xDEFFFFFF),
                    textAlign = TextAlign.Start,
                )

            }

            Text(weatherElement,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                color = Color(0x99FFFFFF)
            )
        }

    }
}