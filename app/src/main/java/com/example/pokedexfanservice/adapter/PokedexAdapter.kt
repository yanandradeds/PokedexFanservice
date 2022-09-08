package com.example.pokedexfanservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.model.SpritesTableModel


class PokedexAdapter(private val context: Context) : RecyclerView.Adapter<PokedexViewHolder>() {

    private lateinit var listSprite: List<SpritesTableModel>
    private val database = PokedexDatabase.getDataBase(context).getDAOInterface()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_pokedex_fragment,parent,false)
        val imageView = view.findViewById<ImageView>(R.id.image_pokemon_sprite)
        imageView.minimumHeight = imageView.width

        return PokedexViewHolder(view)
    }

    override fun onBindViewHolder(itemBinding: PokedexViewHolder, pos: Int) {

        itemBinding.onBind(listSprite[pos])

    }

    override fun getItemCount(): Int {
        return listSprite.size
    }

    suspend fun attachListSprite() {
        listSprite = database.getSpriteAll()
    }
}