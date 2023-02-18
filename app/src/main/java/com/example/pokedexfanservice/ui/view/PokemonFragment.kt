package com.example.pokedexfanservice.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel
import com.example.pokedexfanservice.ui.recyclerview.adapter.PokemonListAdapter
import com.example.pokedexfanservice.viewmodel.PokemonFragmentViewModel

class PokemonFragment() : Fragment() {

    private lateinit var viewModel: PokemonFragmentViewModel
    private val customLayoutManager = GridLayoutManager(context,2)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = PokemonFragmentViewModel(requireContext())
        viewModel.requestDataToApi()

        val view: View = inflater.inflate(R.layout.fragment_pokedex_view,container,false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_list_pokemon)
        val adapter = PokemonListAdapter(listOf())
        val mutableLiveData = viewModel.pokemonList()

        mutableLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
            val s = ""
        }

        recyclerView.layoutManager = customLayoutManager
        recyclerView.adapter = adapter

        return view
    }

}