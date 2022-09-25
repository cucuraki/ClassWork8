package com.example.classwork8.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork8.common.extensions.load
import com.example.classwork8.databinding.ShmotkaLayoutBinding
import com.example.classwork8.domain.models.ShmotkebiModel

class ShmotkebiAdapter :
    ListAdapter<ShmotkebiModel, ShmotkebiAdapter.ShmotkaViewHolder>(ShmotkaDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShmotkaViewHolder(
        ShmotkaLayoutBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: ShmotkaViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ShmotkaViewHolder(private val binding: ShmotkaLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val model = getItem(position)

            binding.price.text = model.price
            binding.image.load(model.cover)
            binding.tittle.text = model.title
        }
    }

}