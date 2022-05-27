package com.updeveloped.pokedexcompose.repository

import com.updeveloped.pokedexcompose.data.remote.response.PokeApi
import com.updeveloped.pokedexcompose.data.remote.response.pokemon.Pokemon
import com.updeveloped.pokedexcompose.data.remote.response.pokemonlist.PokemonList
import com.updeveloped.pokedexcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokeApi){

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error(e.message)
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error(e.message)
        }
        return Resource.Success(response)
    }
}