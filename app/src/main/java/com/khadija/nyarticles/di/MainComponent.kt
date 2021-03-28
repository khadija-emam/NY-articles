package com.khadija.nyarticles.di

import com.khadija.nyarticles.MainActivity
import com.khadija.nyarticles.ui.home.HomeFragment
import dagger.Subcomponent
@Subcomponent
interface MainComponent {
    @Subcomponent.Factory
    interface Factory{
        fun  create(): MainComponent
    }

    fun  inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)

}