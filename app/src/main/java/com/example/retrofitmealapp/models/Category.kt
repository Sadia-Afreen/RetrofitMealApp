package com.example.retrofitmealapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)