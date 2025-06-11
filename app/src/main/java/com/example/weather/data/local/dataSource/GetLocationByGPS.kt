package com.example.weather.data.local.dataSource

import android.annotation.SuppressLint
import android.content.Context
import com.example.weather.data.local.dto.LocationCoordinateDTO
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

class GetLocationByGPS(context:Context):GetLocation{

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override suspend fun getLocation(): LocationCoordinateDTO = suspendCancellableCoroutine { cont ->
        fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { location ->
                if (location != null) {
                    cont.resume(
                        LocationCoordinateDTO(location.latitude, location.longitude),
                        onCancellation = null
                    )
                } else {
                    cont.resumeWithException(Exception("تعذر الحصول على الموقع الحالي"))
                }
            }
            .addOnFailureListener { exception -> cont.resumeWithException(exception) }
    }
    }

