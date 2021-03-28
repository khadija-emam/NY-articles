package com.khadija.nyarticles.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ NetworkModule::class, RepositoryModule::class
    , FactoryModule::class])
  interface ApplicationComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    // Expose RegistrationComponent factory from the graph
    fun mainComponent(): MainComponent.Factory


}