package com.example.pokedexfanservice.ui.recyclerview.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.appconstants.TypeImageConstants
import com.example.pokedexfanservice.appconstants.Types
import com.example.pokedexfanservice.databinding.RowItemTypesFragmentBinding
import com.example.pokedexfanservice.ui.view.PokemonFragmentDirections
import com.example.pokedexfanservice.ui.view.PokemonTypesFilteredFragment
import com.example.pokedexfanservice.ui.view.TypesFragmentDirections


class TypesViewHolder(private val bind: RowItemTypesFragmentBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(pos: Int) {
        bind.imageTypes.setImageResource(TypeImageConstants.resourceImageType(Types.values()[pos]))
        bind.textTitleTypes.text = Types.values()[pos].toString()

    }

    fun setOnClick(controller: NavController, pos: Int) {
        var type: String = Types.values()[pos].toString()
        val action = TypesFragmentDirections.actionTypesFragmentViewToPokemonTypesFilteredFragment(type)

        bind.imageTypes.setOnClickListener(View.OnClickListener {
            controller.navigate(action)
        })

    }


}