package com.example.disneycharacters.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    val created: String,
    @PrimaryKey val _id: Int,
    val name: String,
    val films: String,
    val shortFilms: String,
    val tvShows: String,
    val videoGames: String
)