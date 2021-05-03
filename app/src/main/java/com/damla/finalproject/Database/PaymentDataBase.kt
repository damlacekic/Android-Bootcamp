package com.damla.finalproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Payment::class],version = 1,exportSchema = false)
abstract class PaymentDataBase : RoomDatabase(){
    abstract fun paymentDao() : PaymentDAO

    companion object{
        @Volatile
        private var INSTANCE : PaymentDataBase ?=null
        fun getDataBase(context: Context):PaymentDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        PaymentDataBase::class.java,
                        "payment_database"
                ).allowMainThreadQueries()
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}