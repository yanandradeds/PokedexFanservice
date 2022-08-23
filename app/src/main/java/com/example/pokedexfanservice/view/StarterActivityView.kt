package com.example.pokedexfanservice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexfanservice.databinding.ActivityStarterViewBinding
import com.example.pokedexfanservice.viewmodel.StarterViewModel

class StarterActivityView : AppCompatActivity() {

    lateinit var binding: ActivityStarterViewBinding
    lateinit var viewModel: StarterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarterViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(StarterViewModel::class.java)

        viewModel.getDataFromAPI()
        startActivity(Intent(this,PokedexActivityView::class.java))

    }
}