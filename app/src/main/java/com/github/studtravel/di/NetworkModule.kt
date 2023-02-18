package com.github.studtravel.di

import com.github.studtravel.data.service.INetworkService
import com.github.studtravel.datasource.remote.NetworkService
import com.github.studtravel.datasource.remote.api.StudTravelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BASIC)

        return OkHttpClient()
            .newBuilder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): StudTravelApi {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://stud-api.sabir.pro/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(StudTravelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkService(api: StudTravelApi): INetworkService {
        return NetworkService(api)
    }

}
