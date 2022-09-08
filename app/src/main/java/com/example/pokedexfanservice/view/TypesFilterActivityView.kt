package com.example.pokedexfanservice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.adapter.FilterAdapter
import com.example.pokedexfanservice.constants.Types
import com.example.pokedexfanservice.viewmodel.TypesFilterViewModel
import kotlinx.coroutines.launch

class TypesFilterActivityView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_types_filter_view)
        val viewModel = ViewModelProvider(this).get(TypesFilterViewModel::class.java)
        val layout = LinearLayoutManager(this)
        supportActionBar?.hide()

        val enumType: Types = intent.getSerializableExtra("enum") as Types
        val recycler = findViewById<RecyclerView>(R.id.recycler_filtered_activity)

        viewModel.viewModelScope.launch {
            viewModel.attachDataToArray(enumType)
            recycler.adapter = FilterAdapter(viewModel.getListSprite(), viewModel.getListPokemon())
            recycler.layoutManager = layout
        }

    }
}