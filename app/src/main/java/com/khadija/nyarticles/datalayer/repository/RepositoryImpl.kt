package com.khadija.nyarticles.datalayer.repository

import com.khadija.nyarticles.datalayer.entities.Results
import com.khadija.nyarticles.datalayer.remotedata.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val remoteDataSource: RemoteDataSource):Repository {
    override suspend fun getArticles(): List<Results>? {
        val newsResponse=remoteDataSource.getArticles()
            return newsResponse?.results


    }
}