package com.example.recycleviewdatabinding.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewdatabinding.adapter.ListAdapterItem

abstract class BaseAdapter<BIND : ViewDataBinding,T : ListAdapterItem>(var data: ArrayList<T>):
    RecyclerView.Adapter<BaseViewHolder<BIND>>() {

    @get:LayoutRes
    abstract val layoutId : Int

    abstract fun  bind(binding: BIND,item: T)

    fun updateData(arrayList: ArrayList<T>){
        this.data = arrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BIND> {
        val binder = DataBindingUtil.inflate<BIND>(LayoutInflater.from(parent.context),layoutId,parent,false)
        return BaseViewHolder(binder)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BIND>, position: Int) {
        bind(holder.bind,data[position])
    }

    override fun getItemCount(): Int = data.size

}