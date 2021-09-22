package com.example.mytestapp.data.local

import androidx.room.*
import com.example.mytestapp.model.User


@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll(): List<User>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()
}