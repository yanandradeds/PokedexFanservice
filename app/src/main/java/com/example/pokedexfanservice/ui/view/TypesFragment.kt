package com.example.pokedexfanservice.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.ui.recyclerview.adapter.TypesAdapter
import com.example.pokedexfanservice.viewmodel.TypesFilterViewModel


class TypesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val thisView = inflater.inflate(R.layout.fragment_types_view,container,false)
        val recycler: RecyclerView = thisView.findViewById(R.id.recycler_types)
        val adapterInstance = TypesAdapter()

        recycler.adapter = adapterInstance
        recycler.layoutManager = GridLayoutManager(requireContext(),3)

        return thisView
    }

}