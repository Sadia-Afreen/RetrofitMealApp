package com.example.retrofitmealapp.api

import com.example.retrofitmealapp.models.Category
import com.example.retrofitmealapp.models.MealResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealAPI {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategories() : Response<MealResponse>
}