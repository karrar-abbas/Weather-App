package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun WeekWeatherCard(today:String,high:Int,low:Int,icon:Painter){
    Row (
        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("${low}°C",
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xDFEFFFFF)
            )
            Icon(
                painter = painterResource(R.drawable.arrow_down_04),
                contentDescription = "",
                tint = Color(0xDFEFFFFF),
                modifier = Modifier.size(12.dp)
            )

            VerticalDivider(
                thickness = 1.dp,
                color = Color(0x3DFFFFFF),
                modifier = Modifier.height(14.dp).padding(horizontal = 8.dp)
            )
            Text("${high}°C",
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xDFEFFFFF)
            )
            Icon(
                painter = painterResource(R.drawable.arrow_up),
                contentDescription = "",
                tint = Color(0xDFEFFFFF),
                modifier = Modifier.size(12.dp)
            )
        }
        Image(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(32.dp)
        )
        Text(today,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            color = Color(0x99FFFFFF),
            textAlign = TextAlign.End,
            modifier = Modifier.width(91.dp)
        )
    }
}