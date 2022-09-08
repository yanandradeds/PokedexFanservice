package com.example.pokedexfanservice.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.ActivityLoadingBinding
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.viewmodel.LoadingViewModel
import java.util.*

class LoadingActivity : AppCompatActivity() {

    private lateinit var viewModel: LoadingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val intent = Intent(this,MainActivityView::class.java)

        viewModel = ViewModelProvider(this).get(LoadingViewModel::class.java)

        if(requestData()) startActivity(intent)
    }

    fun requestData(): Boolean {

        return viewModel.getDataFromApi()

    }
}