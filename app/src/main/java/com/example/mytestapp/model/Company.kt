package com.example.mytestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity
class Company {

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: String? = null

    @SerializedName("catchPhrase")
    @Expose
    @ColumnInfo(name = "catchPhrase")
    var catchPhrase: String? = null

    @SerializedName("bs")
    @Expose
    @ColumnInfo(name = "bs")
    var bs: String? = null


}