package com.example.weather.di

import com.example.weather.data.local.dataSource.GetLocation
import com.example.weather.data.local.dataSource.GetLocationByGPS
import com.example.weather.data.local.repository.LocationRepositoryImpl
import com.example.weather.data.remote.dataSource.GetCityName
import com.example.weather.data.remote.dataSource.GetCityNameDataSource
import com.example.weather.data.remote.dataSource.WeatherDataSource
import com.example.weather.data.remote.dataSource.WeatherDataSourceImpl
import com.example.weather.data.remote.repository.CityNameRepositoryImpl
import com.example.weather.data.remote.repository.WeatherRepositoryImpl
import com.example.weather.domain.CityNameRepository
import com.example.weather.domain.LocationRepository
import com.example.weather.domain.WeatherRepository
import com.example.weather.domain.WeatherUseCase
import com.example.weather.viewModel.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Data Layer
    single<WeatherDataSource>{WeatherDataSourceImpl()}
    single<GetLocation>{ GetLocationByGPS(androidContext()) }
    single<GetCityName>{GetCityNameDataSource(androidContext())}
    single<CityNameRepository>{CityNameRepositoryImpl(get())  }
    single<WeatherRepository> { WeatherRepositoryImpl(get(),get()) }
    single<LocationRepository> {LocationRepositoryImpl(get())}

    //Domain Layer
    single{ WeatherUseCase(get(),get()) }

    //ViewModel Layer
    viewModel { WeatherViewModel(get()) }
}