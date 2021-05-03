package com.damla.finalproject.Api

import com.damla.finalproject.Api.Constant.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {



    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL)
            .build()

    }
    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}