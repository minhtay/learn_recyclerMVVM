package com.example.recycleviewdatabinding.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<B : ViewDataBinding>(val bind: B) :
    RecyclerView.ViewHolder(bind.root) {
}