package com.khadija.nyarticles.datalayer.repository

import com.khadija.nyarticles.datalayer.entities.Results

interface Repository {
    suspend fun getArticles():List<Results>?
}