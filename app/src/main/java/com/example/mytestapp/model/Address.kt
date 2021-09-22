package com.example.mytestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity
class Address {

    @SerializedName("street")
    @Expose
    @ColumnInfo(name = "street")
    var street: String? = null

    @SerializedName("suite")
    @Expose
    @ColumnInfo(name = "suite")
    var suite: String? = null

    @SerializedName("city")
    @Expose
    @ColumnInfo(name = "city")
    var city: String? = null

    @SerializedName("zipcode")
    @Expose
    @ColumnInfo(name = "zipcode")
    var zipcode: String? = null

    @SerializedName("geo")
    @Expose
    @ColumnInfo(name = "geo")
    var geo: Geo? = null
}