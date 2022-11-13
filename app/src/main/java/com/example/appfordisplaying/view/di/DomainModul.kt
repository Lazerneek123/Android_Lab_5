package com.example.appfordisplaying.view.di

import com.example.appfordisplaying.view.repository.ListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory{
        ListUseCase(moviesListRepository = get())
    }
}