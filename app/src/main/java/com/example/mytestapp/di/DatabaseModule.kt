package com.example.mytestapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.mytestapp.data.local.AppDatabase
import com.example.mytestapp.data.local.UserDao
import com.example.mytestapp.util.Converter
import dagger.hilt.android.components.ApplicationComponent

import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).build()
    }

    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.movieDao()
    }
}