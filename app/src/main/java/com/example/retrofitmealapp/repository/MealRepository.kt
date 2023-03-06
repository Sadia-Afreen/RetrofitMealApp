package com.example.retrofitmealapp.repository

import com.example.retrofitmealapp.api.RetrofitInstance

class MealRepository{
    suspend fun getCategories()=
        RetrofitInstance.api.getCategories()
}