package com.damla.finalproject.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PaymentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPayment(payment:Payment)

    @Query("Select * from payment_table order by id Asc")
    fun readAllData(): LiveData<List<Payment>>

    @Delete
    suspend fun deletePayment(payment: Payment)

    @Query("Update payment_table set amount =:newAmount where id =:currentid")
    suspend fun changingAmount(newAmount : Double ,currentid:Int)

    @Query("Update payment_table set amountType =:newAmountType where id =:currentid")
    suspend fun changingAmountType(newAmountType : String ,currentid:Int)







}