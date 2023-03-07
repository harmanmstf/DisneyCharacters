package com.example.disneycharacters.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    val created: String,
    @PrimaryKey val _id: Int,
    val imageUrl: String,
    val name: String,
    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>
)