package com.example.retrofitmealapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmealapp.models.Category
import com.example.retrofitmealapp.models.MealResponse
import com.example.retrofitmealapp.repository.MealRepository
import com.example.retrofitmealapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MealViewModel(
    val mealRepository: MealRepository
): ViewModel() {

    val category:MutableLiveData<Resource<MealResponse>> = MutableLiveData()

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        category.postValue(Resource.Loading())
        val response = mealRepository.getCategories()
        category.postValue(handleCategoriesResponse(response))
    }

    private fun handleCategoriesResponse(response: Response<MealResponse>) :Resource<MealResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}