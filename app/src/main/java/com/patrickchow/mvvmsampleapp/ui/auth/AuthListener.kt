package com.patrickchow.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import com.patrickchow.mvvmsampleapp.data.db.entities.User

interface AuthListener {

    //Is called to display the progress bar when a user clicks on login
    fun onStarted()

    //Is called when the authentication is successful
    fun onSuccess(user: User)

    //Is called when the authentication is unsuccessful
    fun onFailure(message: String)

}