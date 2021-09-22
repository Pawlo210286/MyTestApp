package com.example.mytestapp.util

import com.example.mytestapp.model.User

class Util(val user: User) {
    companion object {
        @JvmStatic
        fun getName(user: User) : String {
            return if (user.userDetail!=null)
                user.userDetail!!.name!!
            else
                "Empty name"
        }

        override fun toString(): String {
            return super.toString()
        };
    }


}