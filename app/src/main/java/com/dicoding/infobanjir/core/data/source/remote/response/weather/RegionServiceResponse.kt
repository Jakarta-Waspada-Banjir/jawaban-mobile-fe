package com.dicoding.infobanjir.core.data.source.remote.response.weather

import com.google.gson.annotations.SerializedName

data class RegionServiceResponse(

	@field:SerializedName("RegionServiceResponse")
	val regionServiceResponse: List<RegionServiceResponseItem>
)

data class RegionServiceResponseItem(

	@field:SerializedName("propinsi")
	val propinsi: String,

	@field:SerializedName("kota")
	val kota: String,

	@field:SerializedName("kecamatan")
	val kecamatan: String,

	@field:SerializedName("lon")
	val lon: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("lat")
	val lat: String,
)
