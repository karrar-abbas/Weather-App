package com.example.weather.ui.screens.compsoable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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

@Composable
fun HightAndLowTempBox(
    maxTemp:Double,
    minTemp:Double
){
    Box (
        modifier = Modifier.padding(top = 12.dp)
            .height(35.dp).width(165.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0x14FFFFFF)),
        contentAlignment = Alignment.Center
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("${minTemp.toInt()}°C",
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
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
            Text("${maxTemp.toInt()}°C",
                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
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
    }
}