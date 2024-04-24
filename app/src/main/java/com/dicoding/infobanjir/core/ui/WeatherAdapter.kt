package com.dicoding.infobanjir.core.ui

import android.annotation.*
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*
import coil.*
import com.dicoding.infobanjir.*
import com.dicoding.infobanjir.core.data.source.remote.response.weather.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var weatherList: List<WeatherServiceResponseItem> = emptyList()
    private var regionList: List<RegionServiceResponseItem> = emptyList()

    // Metode untuk menetapkan data baru ke adapter
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newWeatherList: List<WeatherServiceResponseItem>, regionServiceResponseItem: List<RegionServiceResponseItem>) {
        // Mengupdate daftar cuaca dengan yang baru
        regionList = regionServiceResponseItem
        weatherList = newWeatherList
        notifyDataSetChanged()
    }

        inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTemperature: TextView = itemView.findViewById(R.id.weather_temperature)
        private val tvWeatherDescription: TextView = itemView.findViewById(R.id.weather_description)
        private val ivWeatherIcon: ImageView = itemView.findViewById(R.id.weather_icon)
        private val tvWeatherTime: TextView = itemView.findViewById(R.id.weather_time)
        private val tvHumidity: TextView = itemView.findViewById(R.id.weather_humidity)
        private val tvLocation: TextView = itemView.findViewById(R.id.weather_location)

        @SuppressLint("SetTextI18n")
        fun bind(weather: WeatherServiceResponseItem, region: RegionServiceResponseItem) {
            tvWeatherTime.text = weather.jamCuaca
            tvHumidity.text = weather.humidity
            tvLocation.text = "${region.kecamatan}, ${region.kota}, ${region.propinsi}"
            tvTemperature.text = weather.tempC
            tvWeatherDescription.text = weather.cuaca
            ivWeatherIcon.load(weather.kodeCuaca) {
                crossfade(true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherItem = weatherList[position]
        val regionItem = regionList[position]
        holder.bind(weatherItem, regionItem)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}
