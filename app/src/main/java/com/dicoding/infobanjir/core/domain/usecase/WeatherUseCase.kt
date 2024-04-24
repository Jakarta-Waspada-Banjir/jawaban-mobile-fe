package com.dicoding.infobanjir.core.domain.usecase

import com.dicoding.infobanjir.core.data.source.remote.*
import com.dicoding.infobanjir.core.data.source.remote.network.*
import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import kotlinx.coroutines.flow.*
import okhttp3.*

interface WeatherUseCase {

    fun getRegion(): Flow<List<RegionServiceResponseItem>>

    fun getWeather(id: String): Flow<Resource<List<WeatherServiceResponseItem>>>

    fun getIcon(kodeCuaca: String): Flow<ApiResponse<ResponseBody>>

}