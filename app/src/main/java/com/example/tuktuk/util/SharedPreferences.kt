package com.example.tuktuk.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {
    private const val NAME = "TukTuk"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables
    private val IS_LOGIN = Pair("is_login", false)
    private val TOKEN = Pair("token", "")
    private val USERNAME = Pair("username", "")
    private val PASSWORD = Pair("password", "")
    private val PROFILE = Pair("profile", "")
    private val EMAIL = Pair("email", "")
    private val REFRESH = Pair("refresh", "")
    private val IMAGE = Pair("image", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //SharedPreferences variables getters/setters
    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGIN.first, value)
        }

    var username: String
        get() = preferences.getString(USERNAME.first, USERNAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USERNAME.first, value)
        }

    var password: String
        get() = preferences.getString(PASSWORD.first, PASSWORD.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PASSWORD.first, value)
        }

    var token: String
        get() = preferences.getString(TOKEN.first, TOKEN.second) ?: ""
        set(value) = preferences.edit {
            it.putString(TOKEN.first, value)
        }

    var profile: String
        get() = preferences.getString(PROFILE.first, PROFILE.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PROFILE.first, value)
        }

    var email: String
        get() = preferences.getString(EMAIL.first, EMAIL.second) ?: ""
        set(value) = preferences.edit {
            it.putString(EMAIL.first, value)
        }

    var refresh: String
        get() = preferences.getString(REFRESH.first, REFRESH.second) ?: ""
        set(value) = preferences.edit {
            it.putString(REFRESH.first, value)
        }

    var image: String
        get() = preferences.getString(IMAGE.first, IMAGE.second) ?: ""
        set(value) = preferences.edit {
            it.putString(IMAGE.first, value)
        }
}