package com.example.pokedexfanservice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexfanservice.constants.TypeImageConstants
import com.example.pokedexfanservice.databinding.ActivityDetailsViewBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.viewmodel.DetailsViewModel
import com.squareup.picasso.Picasso
import java.lang.NullPointerException

class DetailsActivityView : AppCompatActivity() {

    lateinit var binding: ActivityDetailsViewBinding
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        val bundle = Bundle(intent.extras)

        val type2 = try {
            bundle.getString("type2")
        } catch (e: NullPointerException) {
            null
        }

        Picasso.get().load(bundle.getString("artwork")).into(binding.imagePrincipal)





    }

}