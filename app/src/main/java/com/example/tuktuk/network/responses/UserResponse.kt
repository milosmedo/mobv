package com.example.tuktuk.network.responses

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val token: String,
    val refresh: String,
    val profile: String
)