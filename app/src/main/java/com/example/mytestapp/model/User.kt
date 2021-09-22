package com.example.mytestapp.model

import androidx.annotation.NonNull
import androidx.room.Embedded

import androidx.room.Entity
import androidx.room.Ignore

import androidx.room.PrimaryKey


@Entity
data class User(
    @NonNull
    @PrimaryKey
    val id: Int = 0,
    var userId: String?,
    var title: String?,
    var body: String?
){
    @Embedded
    @Ignore
    var userDetail: UserDetail? = null
}