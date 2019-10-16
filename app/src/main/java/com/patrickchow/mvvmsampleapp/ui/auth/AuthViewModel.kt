package com.patrickchow.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.patrickchow.mvvmsampleapp.util.toast

class AuthViewModel : ViewModel(){
    var email: String? = null

    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid Email or Password")
            return
        }
        authListener?.onSucess()
    }

}
