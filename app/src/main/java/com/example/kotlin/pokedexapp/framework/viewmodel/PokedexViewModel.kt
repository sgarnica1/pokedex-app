package com.example.kotlin.pokedexapp.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.pokedexapp.model.PokedexObject
import com.example.kotlin.pokedexapp.data.PokemonRepository
import com.example.kotlin.pokedexapp.domain.PokemonListRequirement
import com.example.kotlin.pokedexapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokedexViewModel: ViewModel() {
    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()
    private val pokemonListRequirement = PokemonListRequirement()

    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemonRepository = PokemonRepository()
            val result: PokedexObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result)
            }
        }
    }
}