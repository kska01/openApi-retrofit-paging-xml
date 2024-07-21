package com.example.retrofitdrill.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdrill.R
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
            with(binding) {
                tvRegion.text = root.context.getString(R.string.tv_region, animal.orgNm)
                tvSex.text = root.context.getString(R.string.tv_sex, animal.sexCd)
                tvAge.text = root.context.getString(R.string.tv_age, animal.age)
                tvStatus.text = root.context.getString(R.string.tv_status, animal.processState)
            }
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