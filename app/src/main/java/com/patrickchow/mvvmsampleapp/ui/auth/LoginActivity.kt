package com.patrickchow.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.patrickchow.mvvmsampleapp.R
import com.patrickchow.mvvmsampleapp.databinding.ActivityLoginBinding
import com.patrickchow.mvvmsampleapp.util.toast

class LoginActivity : AppCompatActivity(),AuthListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ActivityLoginBinding is automatically generated based off the name of the layout.
        //Ex: activity_login.xml makes ActivityLoginBinding automatically. Might have to do the type inference after the
        //data binding is complete.
        val binding :ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        //Sets the variable viewModel as the binding viewmodel
        binding.viewmodel = viewModel

        //Can assign it to this because this class extends AuthListener
        //This connects this activity to AuthViewModel
        viewModel.authListener = this

    }
    override fun onStarted() {
        this.toast(message = "Login Started")
    }

    override fun onSucess() {
        this.toast(message = "Login Success")
    }

    override fun onFailure(message: String) {
        this.toast(message = message)
    }
}
