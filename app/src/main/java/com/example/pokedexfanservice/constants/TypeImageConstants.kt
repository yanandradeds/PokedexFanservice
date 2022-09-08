package com.example.pokedexfanservice.constants

import com.example.pokedexfanservice.R

class TypeImageConstants() {


    companion object {


        fun resourceImageType(enum: Types): Int {

            when (enum) {
                Types.ICE -> return R.drawable.ice
                Types.GRASS -> return R.drawable.grass
                Types.ELECTRIC -> return R.drawable.electric
                Types.FIRE -> return R.drawable.fire
                Types.DARK -> return R.drawable.dark
                Types.STEEL -> return R.drawable.steel
                Types.FLYING -> return R.drawable.flying
                Types.WATER -> return R.drawable.water
                Types.PSYCHIC -> return R.drawable.psychic
                Types.GHOST -> return R.drawable.ghost
                Types.DRAGON -> return R.drawable.dragon
                Types.FAIRY -> return R.drawable.fairy
                Types.BUG -> return R.drawable.bug
                Types.FIGHTING -> return R.drawable.fighting
                Types.NORMAL -> return R.drawable.normal
                Types.GROUND -> return R.drawable.ground
                Types.ROCK -> return R.drawable.rock
                Types.POISON -> return R.drawable.poison
            }

        }

    }

}