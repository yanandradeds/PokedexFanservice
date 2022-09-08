package com.example.pokedexfanservice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.adapter.PokedexAdapter
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.databinding.FragmentPokedexViewBinding
import com.example.pokedexfanservice.viewmodel.PokedexFragmentViewModel
import kotlinx.coroutines.launch

class PokedexFragmentView() : Fragment() {

    private val customLayoutManager = GridLayoutManager(context,3)
    private lateinit var viewModel: PokedexFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val adapter = PokedexAdapter(requireContext())

        viewModel = PokedexFragmentViewModel(requireContext())
        val view: View = inflater.inflate(R.layout.fragment_pokedex_view,container,false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_list_pokemon)

        viewModel.viewModelScope.launch {
            adapter.attachListSprite()
            recyclerView.layoutManager = customLayoutManager
            recyclerView.adapter = adapter

        }

        return view
    }

}