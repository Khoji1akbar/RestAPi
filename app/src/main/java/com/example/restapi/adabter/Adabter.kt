package com.example.restapi.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.databinding.ItemRvBinding
import com.example.restapi.models.MyTodo

class Adabter(var list: List<MyTodo> = emptyList()) : RecyclerView.Adapter<Adabter.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {


        fun onBind(myTodo: MyTodo, position: Int) {
            itemRvBinding.itemTvAbout.text = myTodo.matn
            itemRvBinding.itemTvHolat.text = myTodo.holat
            itemRvBinding.itemTvSarlavha.text = myTodo.sarlavha
            itemRvBinding.itemTvOxirgiMuddat.text = myTodo.sarlavha
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}

