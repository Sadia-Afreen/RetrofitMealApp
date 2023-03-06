package com.example.retrofitmealapp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitmealapp.databinding.ItemCategoryPreviewBinding
import com.example.retrofitmealapp.models.Category

class CategoryViewHolder(private val binding: ItemCategoryPreviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun onBind(category: Category) {
        Glide.with(binding.root).load(category.strCategoryThumb).into(binding.categoryImage)
        binding.categoryName.text = category.strCategory
//        binding.categoryDescription.text = category.strCategoryDescription
    }
}