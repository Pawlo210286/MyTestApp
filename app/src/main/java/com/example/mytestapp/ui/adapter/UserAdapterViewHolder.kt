package com.example.mytestapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapp.R
import com.example.mytestapp.model.User
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter(private val context: Context, private val list: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder>() {

    class UserAdapterViewHolder(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.tvTitle.text = user.title
            user.userDetail.let {
                itemView.tvName.text = it?.name ?: "Empty Name"
            }
          

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserAdapterViewHolder(context, view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateData(newList: List<User>) {

        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}