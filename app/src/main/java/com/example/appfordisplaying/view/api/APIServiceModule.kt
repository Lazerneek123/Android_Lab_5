package com.example.appfordisplaying.view.api

import org.koin.dsl.module

val APIServiceModule = module {
    factory { APIService().start() }
}