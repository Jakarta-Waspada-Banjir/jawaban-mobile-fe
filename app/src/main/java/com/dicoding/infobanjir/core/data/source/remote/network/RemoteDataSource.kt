package com.dicoding.infobanjir.core.data.source.remote.network

import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.*

class RemoteDataSource(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    fun getRegions(): Flow<ApiResponse<List<RegionServiceResponseItem>>> {
        return flow {
            try {
                val response = withContext(ioDispatcher) {
                    apiService.getRegion()
                }
                val data = response.regionServiceResponse
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(ioDispatcher)
    }

    fun getWeather(id: String): Flow<ApiResponse<List<WeatherServiceResponseItem>>> {
        return flow {
            try {
                val response = withContext(ioDispatcher) {
                    apiService.getWeather(id)
                }
                val data = response.weatherServiceResponse
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(ioDispatcher)
    }

    fun getIcons(kodeCuaca: String): Flow<ApiResponse<ResponseBody>> {
        return flow {
            try {
                val response = withContext(ioDispatcher) {
                    apiService.getIcon(kodeCuaca)
                }
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        emit(ApiResponse.Success(body))
                    } else {
                        emit(ApiResponse.Error("Empty response body"))
                    }
                } else {
                    emit(ApiResponse.Error("Failed to fetch icon"))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }
    }

}