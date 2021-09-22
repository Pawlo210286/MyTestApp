package com.example.mytestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.example.mytestapp.model.User
import com.example.mytestapp.util.Converter

@Database(entities = [User::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): UserDao
}