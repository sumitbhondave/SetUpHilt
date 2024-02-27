package com.explore.setuphilt.di

import com.explore.setuphilt.MainActivity
import com.explore.setuphilt.di.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
