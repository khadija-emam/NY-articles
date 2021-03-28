package com.khadija.nyarticles

import android.app.Application
import com.khadija.nyarticles.di.ApplicationComponent
import com.khadija.nyarticles.di.DaggerApplicationComponent


class MyApplication: Application() {
    // Instance of the AppComponent that will be used by all the Activities in the project


    val appComponent: ApplicationComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}