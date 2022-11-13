package com.example.appfordisplaying.view.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class APIService {
    private val okHTTPTimeout = 100L
    private val url = "https://jsonplaceholder.typicode.com/"

    fun start(): ListService {
        val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(okHTTPTimeout, TimeUnit.SECONDS)
            writeTimeout(okHTTPTimeout, TimeUnit.SECONDS)
            readTimeout(okHTTPTimeout, TimeUnit.SECONDS)

            addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })

        }.build()

        val moshiBuilder = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val moshiConverterFactory = MoshiConverterFactory.create(moshiBuilder)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(moshiConverterFactory)
            .baseUrl(url)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ListService::class.java)
    }
}