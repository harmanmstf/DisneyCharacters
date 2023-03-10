package com.example.disneycharacters.data.repository

import com.example.disneycharacters.data.local.CharacterDao
import com.example.disneycharacters.data.remote.CharacterRemoteDataSource
import com.example.disneycharacters.utils.performGetOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDatasource: CharacterDao,
) {

    fun getCharacter(id: Int) = performGetOperation(
        databaseQuery = { localDatasource.getCharacter(id) },
        networkCall = { remoteDataSource.getCharacter(id) },
        saveCallResult = { localDatasource.insert(it) }
    )

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDatasource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDatasource.insertAll(it.data) }
    )
}