package com.patrickchow.mvvmsampleapp.data.network

import com.patrickchow.mvvmsampleapp.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    // Suspend = Function can be paused and resumed at a later time
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ):Response<AuthResponse>

    companion object{
        // Makes it so that you can use type in MyApi()
        // Instead of typing MyApi.invoke()
        operator fun invoke() : MyApi{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}