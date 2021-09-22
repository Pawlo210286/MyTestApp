package com.example.mytestapp.data

import com.example.mytestapp.data.local.UserDao
import com.example.mytestapp.data.remote.UserRemoteDataSource
import com.example.mytestapp.model.User
import com.example.mytestapp.model.Result
import com.example.mytestapp.model.UserDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Repository which fetches data from Remote or Local data sources
 */
class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userDao: UserDao
) {
    private var users: MutableList<User> = mutableListOf()

    suspend fun fetchUser(): Flow<Result<List<User>>> {
        return flow {

            emit(Result.loading())
            val result = userRemoteDataSource.fetchUser()
            emit(result)
        }.flowOn(Dispatchers.IO)

    }


    private fun fetchUsersCached(): Result<List<User>>? =
        userDao.getAll()?.let {
            Result.success(it)
        }

    suspend fun fetchUserDetail(id: Int): Flow<Result<UserDetail>> {

        return flow {
            emit(userRemoteDataSource.fetchUserDetail(id))
        }.flowOn(Dispatchers.IO)


    }
}