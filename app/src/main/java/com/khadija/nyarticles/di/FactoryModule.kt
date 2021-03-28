package com.khadija.nyarticles.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khadija.nyarticles.ViewModelFactory
import com.khadija.nyarticles.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class FactoryModule {

    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(homeVM: HomeViewModel): ViewModel

}