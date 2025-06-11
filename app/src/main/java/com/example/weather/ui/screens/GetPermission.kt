package com.example.weather.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun RequestLocationPermission(
    onPermissionGranted: () -> Unit
) {
    val context = LocalContext.current

    // Launcher لطلب الصلاحية
    val permissionLauncher = rememberLauncherForActivityResult (
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                onPermissionGranted()
            } else {
                Toast.makeText(context, "الصلاحية مرفوضة", Toast.LENGTH_SHORT).show()
            }
        }
    )

    // حالة الصلاحية حالياً
    val permissionState = remember{
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    // طلب الصلاحية عند أول ظهور للـ Composable إذا لم تُعطَ بعد
    LaunchedEffect (Unit) {
        if (!permissionState.value) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            onPermissionGranted()
        }
    }

    // واجهة عرض بسيطة
    if (permissionState.value) {
        Text("تم منح صلاحية الموقع")
    } else {
        Button(onClick = {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }) {
            Text("طلب صلاحية الموقع")
        }
    }
}
