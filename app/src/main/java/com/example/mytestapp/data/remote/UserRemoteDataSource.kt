package com.example.mytestapp.data.remote

import com.example.mytestapp.model.User
import com.example.mytestapp.network.services.UserService
import com.example.mytestapp.util.ErrorUtils
import com.example.mytestapp.model.Result
import com.example.mytestapp.model.UserDetail

import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * fetches data from remote source
 */
class UserRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun fetchUser(): Result<List<User>> {

        val movieService = retrofit.create(UserService::class.java);
        return getResponse(
                request = { movieService.getUser() },
                defaultErrorMessage = "Error fetching Movie list")

    }

    suspend fun fetchUserDetail(id: Int): Result<UserDetail> {
        val movieService = retrofit.create(UserService::class.java);
        return getResponse(
                request = { movieService.getUserDetail(id) },
                defaultErrorMessage = "Error fetching Movie Description")
    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())!!
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Result.error("Unknown Error", null)
        }
    }


}