package com.example.disneycharacters.data.remote

import com.bumptech.glide.load.engine.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try{
    }
}}