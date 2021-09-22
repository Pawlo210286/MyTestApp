package com.example.mytestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity
class Geo {
    @SerializedName("lat")
    @Expose
    @ColumnInfo(name = "lat")
    var lat: String? = null

    @SerializedName("lng")
    @Expose
    @ColumnInfo(name = "lng")
    var lng: String? = null
}