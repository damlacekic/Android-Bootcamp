package com.damla.finalproject.Database.Repository

import androidx.lifecycle.LiveData
import com.damla.finalproject.Database.Payment
import com.damla.finalproject.Database.PaymentDAO

class PaymentRepository(private val paymentDAO: PaymentDAO) {


    val readAllData : LiveData<List<Payment>> = paymentDAO.readAllData()



    suspend fun addPayment(payment: Payment){
         return paymentDAO.addPayment(payment)
    }
    suspend fun deletePayment(payment: Payment){
        paymentDAO.deletePayment(payment)
    }
    suspend fun changingAmount(newAmount: Double, currencyid : Int){
        paymentDAO.changingAmount(newAmount,currencyid)
    }
    suspend fun changingAmountType(newAmountType: String, currencyid : Int){
        paymentDAO.changingAmountType(newAmountType,currencyid)
    }
}