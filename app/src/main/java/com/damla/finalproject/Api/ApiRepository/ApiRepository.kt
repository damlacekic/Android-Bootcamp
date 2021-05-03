package com.damla.finalproject.Api.ApiRepository

import com.damla.finalproject.Api.Model.Currency
import com.damla.finalproject.Api.RetrofitInstance
import com.damla.finalproject.Api.RetrofitInstance.api
import retrofit2.Call

class ApiRepository {
    private val api by lazy { RetrofitInstance.api }
    fun getConverted(base : String): Call<Currency>{
        return api.getCorverted(base)
    }

}