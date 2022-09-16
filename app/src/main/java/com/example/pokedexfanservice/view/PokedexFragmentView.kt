package com.example.pokedexfanservice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDAO
import com.example.pokedexfanservice.database.tables.PokemonTableModel
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

        viewModel = PokedexFragmentViewModel(requireContext())
        val view: View = inflater.inflate(R.layout.fragment_pokedex_view,container,false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_list_pokemon)

        viewModel.viewModelScope.launch {

            val adapter = viewModel.createAdapter()

            recyclerView.layoutManager = customLayoutManager
            recyclerView.adapter = adapter

            viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
                adapter.notifyItemInserted(it.id-1)

            })

        }

        return view
    }

}