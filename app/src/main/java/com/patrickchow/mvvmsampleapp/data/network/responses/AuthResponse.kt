package com.patrickchow.mvvmsampleapp.data.network.responses

import com.patrickchow.mvvmsampleapp.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)