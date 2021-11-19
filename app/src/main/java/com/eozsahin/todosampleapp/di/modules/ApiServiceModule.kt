package com.eozsahin.todosampleapp.di.modules

import com.eozsahin.todosampleapp.BuildConfig
import com.eozsahin.todosampleapp.api.TodoApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiServiceModule {

    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(Json { ignoreUnknownKeys = true }
            .asConverterFactory("application/json".toMediaType()))
            .client(httpClient)
            .build()

    @Provides
    @Singleton
    fun providesHttpClient() = OkHttpClient().newBuilder().build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) = retrofit.create(TodoApiService::class.java)
}