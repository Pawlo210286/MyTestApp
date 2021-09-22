package com.example.mytestapp.util

import androidx.room.TypeConverter
import com.example.mytestapp.model.UserDetail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromUserDetail(userDetail: UserDetail):String{
        val type = object : TypeToken<UserDetail>() {}.type
        return Gson().toJson(userDetail,type)
    }

    @TypeConverter
    fun toUserDetail(userDetailString: String): UserDetail{
        val type = object : TypeToken<UserDetail>() {}.type
        return Gson().fromJson(userDetailString,type)
    }
}
