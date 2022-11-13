package com.example.appfordisplaying.view.repository

import com.example.appfordisplaying.view.models.Item

interface ListRepository {
    suspend fun getItemList(): List<Item>
}