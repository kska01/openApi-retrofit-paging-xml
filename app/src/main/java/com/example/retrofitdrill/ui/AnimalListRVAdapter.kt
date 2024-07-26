package com.example.retrofitdrill.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdrill.databinding.RvItemAnimalListBinding
import com.example.retrofitdrill.network.model.Item

class AnimalListRVAdapter :
    ListAdapter<Item, AnimalListRVAdapter.AnimalViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.desertionNo == newItem.desertionNo
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    class AnimalViewHolder(private var binding: RvItemAnimalListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Item) {
            binding.animalInfo = animal
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        return AnimalViewHolder(
            RvItemAnimalListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}