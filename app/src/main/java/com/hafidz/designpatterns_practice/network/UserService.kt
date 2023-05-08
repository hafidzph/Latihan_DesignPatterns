package com.hafidz.designpatterns_practice.network

import com.hafidz.designpatterns_practice.model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("user")
    fun getAllUser(): Call<List<GetAllUserItem>>
}