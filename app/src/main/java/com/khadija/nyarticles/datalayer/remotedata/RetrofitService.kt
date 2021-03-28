package com.khadija.nyarticles.datalayer.remotedata

import com.khadija.nyarticles.datalayer.entities.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("mostpopular/v2/viewed/7.json?api-key=NUq7s25AejhirC4VMvyzM0XwW3CPsno6")
    suspend fun getArticles():Response<NewsResponse>
}