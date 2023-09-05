package com.example.kotlin.pokedexapp.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.pokedexapp.R
import com.example.kotlin.pokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.pokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.pokedexapp.model.PokemonBase
import com.example.kotlin.pokedexapp.framework.viewmodel.MainViewModel
import com.example.kotlin.pokedexapp.framework.views.fragments.PokedexFragment
import com.example.kotlin.pokedexapp.framework.views.fragments.SearchFragment
import com.example.kotlin.pokedexapp.utils.Constants

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var currentFragment: Fragment
    private var currentMenuOption: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){

    }

    private fun initializeListeners() {
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenOption(Constants.MENU_POKEDEX)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenOption(Constants.MENU_SEARCH)
        }
    }

    private fun exchangeCurrentFragment(newFragment: Fragment, menuOption: String) {
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, currentFragment)
            .commit()
    }

    private fun selectMenOption(menuOption: String) {
        if(menuOption == currentMenuOption) return

        when(menuOption) {
            Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(), Constants.MENU_SEARCH)
        }
    }


}