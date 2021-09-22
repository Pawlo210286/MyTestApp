package com.example.mytestapp.network.services

import com.example.mytestapp.model.User
import com.example.mytestapp.model.UserDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API Service
 */
interface UserService {

    @GET("/posts")
    suspend fun getUser() : Response<List<User>>
    @GET("/users/{user_id}")
    suspend fun getUserDetail(@Path("user_id") id: Int) : Response<UserDetail>
}