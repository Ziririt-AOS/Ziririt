package com.example.ziririt.presentation.di

import com.example.ziririt.Ziririt
import com.example.ziririt.data.di.RepositoryModule
import dagger.Component

@Component(modules = [RepositoryModule::class])
interface AppComponent {
    fun inject(application: Ziririt)
}