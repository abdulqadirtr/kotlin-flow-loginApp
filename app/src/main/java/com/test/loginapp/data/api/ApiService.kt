package com.test.loginapp.data.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val baseUrl = "https://dummyjson.com/"

object ApiService {

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(contentType))   // ⭐ use your configured json, not the default Json object
        .baseUrl(baseUrl)
        .build()

    val postApi: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }
}