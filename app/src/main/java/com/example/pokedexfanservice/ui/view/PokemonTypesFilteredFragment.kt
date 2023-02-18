package com.example.pokedexfanservice.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.FragmentPokedexViewBinding
import com.example.pokedexfanservice.databinding.FragmentPokemonTypesFilteredBinding
import com.example.pokedexfanservice.ui.recyclerview.adapter.PokemonListAdapter
import com.example.pokedexfanservice.viewmodel.TypesFilterViewModel

class PokemonTypesFilteredFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPokemonTypesFilteredBinding.inflate(inflater)
        val viewModel = TypesFilterViewModel(requireContext())
        val type = requireArguments().getString("pokemonType")!!
        val mAdapter = PokemonListAdapter(listOf())
        val listLiveData = viewModel.getMutableLiveDataListPokemon()

        viewModel.filterListPokemon(type)

        listLiveData.observe(viewLifecycleOwner){
            mAdapter.updateData(it)
        }

        binding.recyclerListPokemon.adapter = mAdapter
        binding.recyclerListPokemon.layoutManager = GridLayoutManager(context,2)

        return binding.root
    }

}