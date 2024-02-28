package com.explore.setuphilt.data.api

import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        @Volatile
        private var instance: UserApiService? = null

        fun getInstance(): UserApiService {
            return instance ?: synchronized(this) {
                instance ?: buildApiClient().also { instance = it }
            }
        }

        private fun buildApiClient(): UserApiService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(UserApiService::class.java)
        }
    }
}