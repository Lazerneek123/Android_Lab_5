package com.example.appfordisplaying.view.api

import com.example.appfordisplaying.view.models.Item
import retrofit2.http.GET

interface ListService {
    @GET("photos")
    suspend fun getItems(): List<Item>
}