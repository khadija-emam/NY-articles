package com.khadija.nyarticles.datalayer.remotedata

import com.google.gson.Gson
import com.khadija.nyarticles.datalayer.entities.NewsResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val retrofitService: RetrofitService):RemoteDataSource {
    override suspend fun getArticles(): NewsResponse? {
        val response = retrofitService.getArticles()
         if (response.isSuccessful) {
                 return response.body()

         }else{
             val gson = Gson()
             val eventResponse =
                 gson.fromJson(response.errorBody()!!.string(), NewsResponse::class.java)
              throw Exception(eventResponse.status)
         }
    }
}