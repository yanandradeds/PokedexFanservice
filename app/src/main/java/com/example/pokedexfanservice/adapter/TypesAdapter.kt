package com.example.pokedexfanservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R

class TypesAdapter : RecyclerView.Adapter<TypesViewHolder>() {

    private lateinit var view: View
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        context = parent.context
        view = LayoutInflater.from(context).inflate(R.layout.row_item_types_fragment,parent,false)
        return TypesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypesViewHolder, pos: Int) {
        holder.bind(pos)
    }

    override fun getItemCount() = 18

}