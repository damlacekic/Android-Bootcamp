package com.damla.finalproject.Api

import com.damla.finalproject.Api.Model.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("v6/tq7k63b4j5zv7d75btfyc5qt/latest/{base_code}")
    fun getCorverted(@Path("base_code") base_code :String):Call<Currency>

}