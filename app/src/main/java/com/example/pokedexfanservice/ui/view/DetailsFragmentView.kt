package com.example.pokedexfanservice.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.viewmodel.MovesFragmentViewModel


class DetailsFragmentView : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this).get(MovesFragmentViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_details_view, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_moves_act)

        return view
    }

}