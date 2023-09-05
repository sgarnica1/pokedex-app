package com.example.kotlin.pokedexapp.data

import com.example.kotlin.pokedexapp.data.network.NetworkModelDI
import com.example.kotlin.pokedexapp.data.network.PokemonAPIClient
import com.example.kotlin.pokedexapp.model.PokedexObject
import com.example.kotlin.pokedexapp.data.network.PokemonAPIService
import com.example.kotlin.pokedexapp.model.pokemon.Pokemon

class PokemonRepository {

    private val apiPokemon = PokemonAPIClient()

    suspend fun getPokemonList(limit: Int): PokedexObject? = apiPokemon.getPokemonList(limit)
    suspend fun getPokemonInfo(numberPokemon: Int): Pokemon? = apiPokemon.getPokemonInfo(numberPokemon)
}