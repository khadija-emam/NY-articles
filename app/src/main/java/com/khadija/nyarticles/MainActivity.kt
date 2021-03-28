package com.khadija.nyarticles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.khadija.nyarticles.databinding.ActivityMainBinding
import com.khadija.nyarticles.di.MainComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainComponent: MainComponent
    lateinit var  binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent=(application as MyApplication).appComponent.mainComponent().create()
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

}