package com.example.disneycharacters.data.remote

import com.example.disneycharacters.data.entities.Character
import com.example.disneycharacters.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface  CharacterService{
    @GET("characters")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("characters/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}