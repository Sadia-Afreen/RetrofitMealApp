package com.example.retrofitmealapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofitmealapp.adapters.MealAdapter
import com.example.retrofitmealapp.databinding.ActivityMainBinding
import com.example.retrofitmealapp.repository.MealRepository
import com.example.retrofitmealapp.util.Resource

class MainActivity : AppCompatActivity() {
    private lateinit var mealAdapter:MealAdapter
    private lateinit var viewModel: MealViewModel
    lateinit var binding: ActivityMainBinding

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mealRepository = MealRepository()
        val viewModelProviderFactory = MealViewModelProviderFactory(mealRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory)[MealViewModel::class.java]
        setupRecyclerView()

        viewModel.category.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { mealResponse ->
                        mealAdapter.differ.submitList(mealResponse.categories)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> Log.e(TAG, "Loading")
            }
        }
    }
    private fun setupRecyclerView() {
        mealAdapter = MealAdapter()
        binding.recyclerViewCategory.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewCategory.setHasFixedSize(true)
        binding.recyclerViewCategory.adapter = mealAdapter

    }

}