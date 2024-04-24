package com.dicoding.infobanjir.fragment.dashboard

import androidx.lifecycle.*
import com.dicoding.infobanjir.core.data.source.remote.*
import com.dicoding.infobanjir.core.data.source.remote.network.*
import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import com.dicoding.infobanjir.core.domain.usecase.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.*

class DashboardViewModel(private val useCase: WeatherUseCase) : ViewModel() {

}
