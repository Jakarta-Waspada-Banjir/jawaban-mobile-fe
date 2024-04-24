package com.dicoding.infobanjir.core.domain.usecase

import com.dicoding.infobanjir.core.data.source.remote.*
import com.dicoding.infobanjir.core.data.source.remote.network.*
import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import com.dicoding.infobanjir.core.domain.repository.*
import kotlinx.coroutines.flow.*
import okhttp3.*

class WeatherInteractor(
    private val weatherRepository: IWeatherRepository
) : WeatherUseCase {
    override fun getRegion(): Flow<List<RegionServiceResponseItem>> = weatherRepository.getRegion()

    override fun getWeather(id: String): Flow<Resource<List<WeatherServiceResponseItem>>> = weatherRepository.getWeather(id)

    override fun getIcon(kodeCuaca: String): Flow<ApiResponse<ResponseBody>> = weatherRepository.getIcon(kodeCuaca)


}