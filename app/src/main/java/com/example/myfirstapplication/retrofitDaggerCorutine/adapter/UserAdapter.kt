package com.example.myfirstapplication.retrofitDaggerCorutine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.ItemUserBinding
import com.example.myfirstapplication.retrofitDaggerCorutine.dataClasses.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users: List<User> = emptyList()

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    /*
    This method is called by the RecyclerView when it needs a new ViewHolder to represent an item.
    It inflates the item layout XML and returns a new ViewHolder associated with the inflated view.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    // This method is called by the RecyclerView to display the data at the specified position.
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userName.text = user.name
            binding.userEmail.text = user.email
        }
    }

    /*
    onAttachedToRecyclerView(RecyclerView):
    This method is called when the adapter is attached to the RecyclerView. You can perform any initialization tasks here.
    onDetachedFromRecyclerView(RecyclerView):
    This method is called when the adapter is detached from the RecyclerView. You can perform any cleanup tasks here.
     */
}