package com.dicoding.infobanjir.core.data.source.remote

import com.dicoding.infobanjir.core.data.source.remote.network.*
import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import com.dicoding.infobanjir.core.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.*
import okhttp3.*

class WeatherRepository(
    private val remoteDataSource: RemoteDataSource
) : IWeatherRepository {
    override fun getRegion(): Flow<List<RegionServiceResponseItem>> {
        return remoteDataSource.getRegions()
            .map { response ->
                when (response) {
                    is ApiResponse.Success -> response.data
                    is ApiResponse.Error -> emptyList()
                    is ApiResponse.Empty -> emptyList()
                }
            }
    }

    override fun getWeather(id: String): Flow<Resource<List<WeatherServiceResponseItem>>> {
        return remoteDataSource.getWeather(id)
            .map { response ->
                when (response) {
                    is ApiResponse.Success -> Resource.Success(response.data)
                    is ApiResponse.Error -> Resource.Error(response.toString())
                    is ApiResponse.Empty -> Resource.Error("Empty response") // Menangani kasus ApiResponse.Empty
                }
            }
    }

    override fun getIcon(kodeCuaca: String): Flow<ApiResponse<ResponseBody>> {
        return remoteDataSource.getIcons(kodeCuaca)
    }
}

