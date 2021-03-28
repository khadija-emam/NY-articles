package com.khadija.nyarticles.di



import com.khadija.nyarticles.datalayer.repository.Repository
import com.khadija.nyarticles.datalayer.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.BinderRepository::class])
class RepositoryModule {
     @Module
     interface  BinderRepository
     {
            @Binds
            fun authRepositoryBind(authRepositoryImpl: RepositoryImpl): Repository


     }


}