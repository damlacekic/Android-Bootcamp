package com.damla.finalproject.ViewModel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.damla.finalproject.Api.ApiRepository.ApiRepository
import com.damla.finalproject.Api.Model.ConversionRates
import com.damla.finalproject.Api.Model.Currency
import com.damla.finalproject.Database.Payment
import com.damla.finalproject.Database.PaymentDataBase
import com.damla.finalproject.Database.Repository.PaymentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentViewModel(application : Application):AndroidViewModel(application) {

    val readAllData : LiveData<List<Payment>>
    val repositoryData : PaymentRepository
    var myResponse: MutableLiveData<Currency> = MutableLiveData()
    val preferences = application.getSharedPreferences("com.damla.finalproject", Context.MODE_PRIVATE)
    private val repository by lazy { ApiRepository() }

    init{
        val paymentDAO = PaymentDataBase.getDataBase(application).paymentDao()
        repositoryData = PaymentRepository(paymentDAO)
        readAllData = repositoryData.readAllData
    }
    fun getConverted(base:String) {
        viewModelScope.launch {
            repository.getConverted(base).enqueue(object : Callback<Currency> {
                override fun onResponse(call: Call<Currency>, response: Response<Currency>) {
                    if (response.isSuccessful) {
                        preferences?.edit()?.putFloat("USDToTRY", response.body()!!.conversion_rates.USD.toFloat())?.apply()
                        preferences?.edit()?.putFloat("GBPToTRY", response.body()!!.conversion_rates.GBP.toFloat())?.apply()
                        preferences?.edit()?.putFloat("EURToTRY", response.body()!!.conversion_rates.EUR.toFloat())?.apply()
                        myResponse.value = response.body()
                        println(response.body())


                    }
                }

                override fun onFailure(call: Call<Currency>, t: Throwable) {

                    val usd = preferences?.getFloat("USDToTRY", 0.121F)?.toDouble()!!
                    val gbp = preferences?.getFloat("GBPToTRY", 0.08725F)?.toDouble()!!
                    val eur = preferences?.getFloat("EURToTRY", 0.1003F)?.toDouble()!!
                    myResponse.value = (Currency(base, ConversionRates(eur, gbp, 1.0, usd)))


                }

            })



        }


    }

    fun addPayment(payment: Payment){
        viewModelScope.launch(Dispatchers.IO){
            repositoryData.addPayment(payment)
        }


    }

    fun deletePayment(payment: Payment){
        viewModelScope.launch(Dispatchers.IO){
            repositoryData.deletePayment(payment)
        }
    }
    fun changingAmount(newAmount: Double,currentid:Int){
        viewModelScope.launch(Dispatchers.IO){
            repositoryData.changingAmount(newAmount,currentid )
        }
    }

    fun changingAmountType(newAmountType: String,currentid:Int){
        viewModelScope.launch(Dispatchers.IO){
            repositoryData.changingAmountType(newAmountType,currentid )
        }
    }


    fun changeTheUser(preferences: SharedPreferences?, nameText: TextView) {
        var changingUserGender = preferences?.getInt("gender", 2)
        var userName = preferences?.getString("user", "")

        if (changingUserGender != null) {
            if (changingUserGender == 0) {
                nameText.text = userName + " Hanım"
            }
            if (changingUserGender == 1) {
                nameText.text = userName + " Bey"
            }
            if (changingUserGender == 2) {
                nameText.text = userName
            }
        }
    }

}