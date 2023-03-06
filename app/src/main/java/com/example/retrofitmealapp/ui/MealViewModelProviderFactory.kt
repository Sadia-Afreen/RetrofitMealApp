package com.example.retrofitmealapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmealapp.repository.MealRepository

class MealViewModelProviderFactory(
    val mealRepository: MealRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealViewModel(mealRepository) as T
    }
}