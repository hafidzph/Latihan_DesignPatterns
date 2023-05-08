package com.hafidz.designpatterns_practice.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafidz.designpatterns_practice.model.GetAllUserItem
import com.hafidz.designpatterns_practice.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val app: Application): AndroidViewModel(app) {
    private val _user = MutableLiveData<List<GetAllUserItem>>()
    val user: LiveData<List<GetAllUserItem>> = _user

    fun getAllUser(){
        APIClient.instance.getAllUser()
            .enqueue(object : Callback<List<GetAllUserItem>> {
                override fun onResponse(
                    call: Call<List<GetAllUserItem>>,
                    response: Response<List<GetAllUserItem>>
                ) {
                    if(response.isSuccessful) _user.postValue(response.body())
                }

                override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                    Toast.makeText(app, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}