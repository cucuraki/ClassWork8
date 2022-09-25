package com.example.classwork8.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.classwork8.domain.models.ShmotkebiModel

class ShmotkaDiffUtil : DiffUtil.ItemCallback<ShmotkebiModel>() {
    override fun areItemsTheSame(oldItem: ShmotkebiModel, newItem: ShmotkebiModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ShmotkebiModel, newItem: ShmotkebiModel) =
        oldItem == newItem
}