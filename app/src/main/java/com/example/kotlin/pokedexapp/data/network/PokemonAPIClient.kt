package com.example.kotlin.pokedexapp.data.network

import com.example.kotlin.pokedexapp.model.PokedexObject

class PokemonAPIClient {
    private lateinit var api: PokemonAPIService

    class PokemonAPIClient(){}

    suspend fun getPokemonList(limit: Int): PokedexObject?{
        api = NetworkModelDI()
        return try {
            api.getPokemonList(limit)
        } catch (e:java.lang.Exception) {
            e.printStackTrace()
            null
        }

    }

    suspend fun getPokemonInfo(numberPokemon: Int): com.example.kotlin.pokedexapp.model.pokemon.Pokemon?{
        api = NetworkModelDI()
        return try {
            api.getPokemonInfo(numberPokemon)
        } catch(e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}