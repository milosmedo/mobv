package com.example.tuktuk.profile

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tuktuk.database.DataRepository
import java.io.File
import java.net.URI

class ProfileViewModel(
    private val repository: DataRepository
) : ViewModel() {
    val name = ObservableField<String>("")
    val email = ObservableField<String>("")

    init {

    }

    suspend fun userInfo(action: String, token: String): Int {
        return repository.userInfo(action, token)
    }

    suspend fun userLogout(action: String, refresh: String): Int {
        Log.i("INFO", refresh)
        return repository.tokenRefresh(action, refresh)
    }

    suspend fun uploadImage(
        fileUri: File,
        token: String,
        context: Context
    ): Int {
        return repository.uploadImage(fileUri, token, context)
    }
}