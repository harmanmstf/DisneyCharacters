package com.example.disneycharacters.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DataConverter {
    @TypeConverter
    fun fromList(value: List<String>): String {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}. type
        return gson.fromJson(value, type)
    }
}