package com.example.mytestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity
data class UserDetail(
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: String? = null,

    @SerializedName("username")
    @Expose
    @ColumnInfo(name = "username")
    var username: String? = null,

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "email")
    var email: String? = null,

//    @SerializedName("address")
//    @Expose
//    @ColumnInfo(name = "address")
//    var address: Address? = null,

    @SerializedName("phone")
    @Expose
    @ColumnInfo(name = "phone")
    var phone: String? = null,

    @SerializedName("website")
    @Expose
    @ColumnInfo(name = "website")
    var website: String? = null

//    @SerializedName("company")
//    @Expose
//    @ColumnInfo(name = "company")
//    var company: Company? = null,
)