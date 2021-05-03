package com.damla.finalproject.Api

import com.damla.finalproject.Api.Model.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET("v6/55484c3d8c8554e044e102fa/latest/{base_code}")
    fun getCorverted(@Path("base_code") base_code :String):Call<Currency>

}