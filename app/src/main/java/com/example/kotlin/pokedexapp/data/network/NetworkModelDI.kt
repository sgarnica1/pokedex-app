package com.example.kotlin.pokedexapp.data.network

import com.example.kotlin.pokedexapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModelDI {

    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    operator fun invoke(): PokemonAPIService {
        return (
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonFactory)
                .build()
                .create(PokemonAPIService::class.java)
        )
    }
}