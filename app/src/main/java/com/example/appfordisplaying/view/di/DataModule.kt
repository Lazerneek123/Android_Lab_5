package com.example.appfordisplaying.view.di

import com.example.appfordisplaying.view.repository.ListRepositoryImpl
import com.example.appfordisplaying.view.repository.ListRepository
import org.koin.dsl.module

val dataModule = module {
    single<ListRepository> {
        ListRepositoryImpl(listService = get())
    }
}