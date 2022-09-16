package com.example.pokedexfanservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.database.tables.MovesTableModel

class MovesAdapter(context: Context, moves: List<MovesTableModel>): RecyclerView.Adapter<MovesViewHolder>() {

    private val listAllMoves = moves

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_moves_activity,parent,false)
        return MovesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovesViewHolder, position: Int) {
        holder.onBind(listAllMoves[position])
    }

    override fun getItemCount(): Int {
        return listAllMoves.size
    }

}