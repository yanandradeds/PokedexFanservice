package com.example.pokedexfanservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RecycleViewItemBinding
import com.example.pokedexfanservice.model.tablemodel.PokemonTableModel



class PokedexAdapter(private val list: List<PokemonTableModel>) : RecyclerView.Adapter<PokedexViewHolder>() {

    private lateinit var context: Context
    private lateinit var binding: RecycleViewItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

        context = parent.context
        binding = RecycleViewItemBinding.inflate(LayoutInflater.from(context))

        return PokedexViewHolder(binding)
    }

    override fun onBindViewHolder(itemBinding: PokedexViewHolder, pos: Int) {

        val pokemon = list[pos]

        itemBinding.onClickListener(pokemon,context)
        itemBinding.setItemImage(pokemon)

    }


    override fun getItemCount(): Int {
        return list.size
    }

}