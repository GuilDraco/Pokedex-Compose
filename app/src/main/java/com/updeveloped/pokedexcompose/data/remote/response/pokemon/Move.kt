package com.updeveloped.pokedexcompose.data.remote.response.pokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)