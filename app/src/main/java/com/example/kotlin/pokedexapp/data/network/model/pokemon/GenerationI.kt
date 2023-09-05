package com.example.kotlin.pokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue") val red_blue: com.example.kotlin.pokedexapp.model.pokemon.RedBlue,
    val yellow: com.example.kotlin.pokedexapp.model.pokemon.Yellow
)