package com.example.pokedexfanservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.ItemRowTypesFragmentBinding
import com.example.pokedexfanservice.view.TypesFragmentView

class TypesAdapter : RecyclerView.Adapter<TypesViewHolder>() {

    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_types_fragment,parent,false)
        return TypesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypesViewHolder, pos: Int) {


        holder.bind(pos)

    }

    override fun getItemCount() = 18

}