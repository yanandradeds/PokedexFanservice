package com.example.pokedexfanservice.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.ui.recyclerview.adapter.TypesAdapter


class TypesFragmentView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val thisView = inflater.inflate(R.layout.fragment_types_view,container,false)
        val recycler: RecyclerView = thisView.findViewById(R.id.recycler_types)

        recycler.adapter = TypesAdapter()
        recycler.layoutManager = GridLayoutManager(requireContext(),3)

        return thisView
    }

    companion object {

        val fragment = TypesFragmentView()

    }
}