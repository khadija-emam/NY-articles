package com.khadija.nyarticles.datalayer.remotedata

import com.khadija.nyarticles.datalayer.entities.NewsResponse

interface RemoteDataSource {
    suspend fun getArticles():NewsResponse?
}