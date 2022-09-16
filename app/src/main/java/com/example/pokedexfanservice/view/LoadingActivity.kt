package com.example.pokedexfanservice.view


import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.viewmodel.LoadingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoadingActivity : AppCompatActivity() {

    private lateinit var viewModel: LoadingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val intent = Intent(this,MainActivityView::class.java)
        viewModel = ViewModelProvider(this).get(LoadingViewModel::class.java)


        viewModel.viewModelScope.launch(Dispatchers.IO){
            viewModel.getDataFromApi()
            startActivity(intent)
            finish()
        }
    }

}