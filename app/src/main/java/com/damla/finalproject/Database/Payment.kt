package com.damla.finalproject.Database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "payment_table")
data class Payment(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val vektor:Int,
        val section : String,
        var amount : Double,
        var amountType : String

        ):Parcelable
