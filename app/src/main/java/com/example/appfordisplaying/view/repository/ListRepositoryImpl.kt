package com.example.appfordisplaying.view.repository

import com.example.appfordisplaying.view.api.ListService

class ListRepositoryImpl(private val listService: ListService) : ListRepository {
    override suspend fun getItemList() = listService.getItems()
}