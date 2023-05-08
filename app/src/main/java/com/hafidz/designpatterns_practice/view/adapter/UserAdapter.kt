package com.hafidz.designpatterns_practice.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafidz.designpatterns_practice.databinding.UserItemBinding
import com.hafidz.designpatterns_practice.model.GetAllUserItem

class UserAdapter(var listUser: List<GetAllUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: GetAllUserItem){
            binding.name.text = user.name
            binding.age.text = user.age.toString()
            binding.address.text = user.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listUser[position])
}