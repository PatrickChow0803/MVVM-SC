package com.patrickchow.mvvmsampleapp.ui.auth

interface AuthListener {

    //Is called to display the progress bar when a user clicks on login
    fun onStarted()

    //Is called when the authentication is successful
    fun onSucess()

    //Is called when the authentication is unsuccessful
    fun onFailure(message: String)

}