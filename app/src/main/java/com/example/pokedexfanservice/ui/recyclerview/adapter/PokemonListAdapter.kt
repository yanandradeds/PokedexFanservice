package com.example.pokedexfanservice.ui.recyclerview.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RowItemPokemonFragmentBinding
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel
import com.example.pokedexfanservice.ui.recyclerview.viewholder.PokemonFragmentViewHolder

class PokemonListAdapter(private var dataSet: List<DatabasePokemonModel>):
    RecyclerView.Adapter<PokemonFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonFragmentViewHolder {
        val view = RowItemPokemonFragmentBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)

        return PokemonFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonFragmentViewHolder, position: Int) {
        holder.setVisualsComponentsRecyclerViewsRow(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun updateData(newDataset: List<DatabasePokemonModel>) {
        dataSet = newDataset
        notifyDataSetChanged()
    }

}