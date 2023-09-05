package com.example.kotlin.pokedexapp.data.network

import com.example.kotlin.pokedexapp.model.PokedexObject
import com.example.kotlin.pokedexapp.model.pokemon.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPIService {

    //https://pokeapi.co/api/v2/ //URL BASE

    //https://pokeapi.co/api/v2/pokemon?limit=1279
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): PokedexObject

    //https://pokeapi.co/api/v2/pokemon/{number_pokemon}/
    @GET("pokemon/{number_pokemon}/")
    suspend fun getPokemonInfo(@Path("number_pokemon") numberPokemon: Int): com.example.kotlin.pokedexapp.model.pokemon.Pokemon
}