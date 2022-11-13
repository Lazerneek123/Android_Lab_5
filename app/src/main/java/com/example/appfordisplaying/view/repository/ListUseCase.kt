package com.example.appfordisplaying.view.repository

class ListUseCase(private val moviesListRepository: ListRepository) {
    suspend fun loadItemList() = moviesListRepository.getItemList()
}
