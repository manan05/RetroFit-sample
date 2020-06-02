package com.example.retrofit_sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(usersList: MutableList<RetroUsers?>?) : RecyclerView.Adapter<MyAdapter.CustomViewHolder>() {
    private var dataList: List<RetroUsers>? = null


    public fun MyAdapter(dataList: List<RetroUsers?>?){
        this.dataList = dataList as List<RetroUsers>?
    }
    class CustomViewHolder(myView: View) :
        RecyclerView.ViewHolder(myView) {
        var textUser: TextView = myView.findViewById(R.id.tvUser)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.row_layout,parent,false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size!!
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.textUser.text = dataList!![position].getUser()
    }

}

