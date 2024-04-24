package com.dicoding.infobanjir.core.data.source.remote.network

import com.dicoding.infobanjir.core.data.source.remote.response.weather.*
import okhttp3.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/cuaca/idWilayah.json")
     fun getRegion(): RegionServiceResponse

    @GET("/cuaca/{id}")
     fun getWeather(
        @Path("/cuaca/{id}.json") id: String
    ): WeatherServiceResponse

    @GET("icon/{KodeCuaca}.png")
    fun getIcon(@Path("KodeCCuaca") kodeCuaca: String): Response<ResponseBody>

}