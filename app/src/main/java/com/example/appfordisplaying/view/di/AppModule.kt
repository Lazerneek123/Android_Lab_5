package com.example.appfordisplaying.view.di

import com.example.appfordisplaying.view.viewModels.FragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        FragmentViewModel(listUseCase = get(), application = get())
    }
}