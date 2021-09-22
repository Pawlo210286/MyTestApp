package com.example.mytestapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytestapp.data.UserRepository
import com.example.mytestapp.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import com.example.mytestapp.model.Result
import kotlinx.coroutines.android.awaitFrame

class MainViewModel @ViewModelInject constructor(private val userRepository: UserRepository) :
    ViewModel() {

    private val _userList = MutableLiveData<Result<List<User>>>()
    val userList = _userList

    init {
        fetchUser()
    }

    private fun fetchUser() {

        viewModelScope.launch {
            userRepository.fetchUser().collect { it ->
                if (it.status == Result.Status.SUCCESS) {
                        for (user in it.data!!) {
                            userRepository.fetchUserDetail(user.id).collect {
                                it.data.let { userDetail ->
                                    user.userDetail= userDetail
                                }
                            }.also {
                                awaitFrame()
                            }
                        }
                userList.value = it



                }

            }

        }



    }
}