package com.dicoding.infobanjir.core.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName

data class WeatherServiceResponse(

	@field:SerializedName("WeatherServiceResponse")
	val weatherServiceResponse: List<WeatherServiceResponseItem>
)

data class WeatherServiceResponseItem(

	@field:SerializedName("tempF")
	val tempF: String,

	@field:SerializedName("kodeCuaca")
	val kodeCuaca: String,

	@field:SerializedName("cuaca")
	val cuaca: String,

	@field:SerializedName("jamCuaca")
	val jamCuaca: String,

	@field:SerializedName("humidity")
	val humidity: String,

	@field:SerializedName("tempC")
	val tempC: String,
)
