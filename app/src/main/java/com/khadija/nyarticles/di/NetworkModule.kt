package com.khadija.nyarticles.di

import com.khadija.nyarticles.datalayer.remotedata.RemoteDataSource
import com.khadija.nyarticles.datalayer.remotedata.RemoteDataSourceImpl
import com.khadija.nyarticles.datalayer.remotedata.RetrofitService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// @Module informs Dagger that this class is a Dagger Module
@Module(includes = [NetworkModule.Binders::class])
class NetworkModule {
    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.
    @Singleton
    @Provides
    fun RetrofitService(): RetrofitService {
        //  String language= Resources.getSystem().getConfiguration().locale.getLanguage();
        val client = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
        // this code (the one inside the @Provides method) is run.
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RetrofitService::class.java)
    }


    // tell dagger to create instance when need to implement userRemoteDataSource
    @Module
    interface Binders {
        @Binds
        abstract  fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    }

}