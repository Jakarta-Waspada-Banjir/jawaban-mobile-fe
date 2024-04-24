package com.dicoding.infobanjir.di

import com.dicoding.infobanjir.fragment.dashboard.DashboardViewModel
import com.dicoding.infobanjir.core.domain.usecase.*
import org.koin.androidx.viewmodel.dsl.*
import org.koin.dsl.*

val useCaseModule = module {
    factory<WeatherUseCase> { WeatherInteractor(get()) }
}

val viewModelModule = module {
    viewModel { DashboardViewModel(get()) }
}