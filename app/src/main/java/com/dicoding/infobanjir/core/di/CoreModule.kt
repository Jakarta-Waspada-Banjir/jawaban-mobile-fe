package com.dicoding.infobanjir.core.di

import com.dicoding.infobanjir.*
import com.dicoding.infobanjir.core.data.source.remote.*
import com.dicoding.infobanjir.core.data.source.remote.network.*
import com.dicoding.infobanjir.core.domain.repository.*
import com.dicoding.infobanjir.core.utils.*
import okhttp3.*
import okhttp3.logging.*
import org.koin.dsl.*
import retrofit2.*
import retrofit2.converter.gson.*
import java.util.concurrent.*

val networkModule = module {
    single {
        val loggingInterceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder().baseUrl("https://ibnux.github.io/BMKG-importer/")
            .addConverterFactory(GsonConverterFactory.create()).client(get()).build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }

    single<IWeatherRepository> {
        WeatherRepository(
            get()
        )
    }
}