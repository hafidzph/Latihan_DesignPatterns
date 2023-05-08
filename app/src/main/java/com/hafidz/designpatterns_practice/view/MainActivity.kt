package com.hafidz.designpatterns_practice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafidz.designpatterns_practice.databinding.ActivityMainBinding
import com.hafidz.designpatterns_practice.model.GetAllUserItem
import com.hafidz.designpatterns_practice.view.adapter.UserAdapter
import com.hafidz.designpatterns_practice.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val userVM: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        getAllUser()
    }

    fun getAllUser(){
        userVM.getAllUser()
        userVM.user.observe(this){ user ->
            binding?.rvClient?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding?.rvClient?.adapter = UserAdapter(user)
        }
    }
}