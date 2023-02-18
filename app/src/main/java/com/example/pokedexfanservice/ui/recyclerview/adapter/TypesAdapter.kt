package com.example.pokedexfanservice.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.RowItemTypesFragmentBinding
import com.example.pokedexfanservice.ui.recyclerview.viewholder.TypesViewHolder

class TypesAdapter : RecyclerView.Adapter<TypesViewHolder>() {

    private lateinit var binding: RowItemTypesFragmentBinding
    private lateinit var context: Context
    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        context = parent.context
        binding = RowItemTypesFragmentBinding.inflate(LayoutInflater.from(context))
        navController = parent.findNavController()
        return TypesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TypesViewHolder, pos: Int) {
        holder.bind(pos)
        holder.setOnClick(navController,pos)
    }

    override fun getItemCount() = 18

}