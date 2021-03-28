package com.khadija.nyarticles.repository

import com.khadija.nyarticles.datalayer.entities.Results
import com.khadija.nyarticles.datalayer.repository.Repository

class FakeRepository (private val hasError: Boolean = false):Repository{

    override suspend fun getArticles(): List<Results>? {
        return if (!hasError) listOf(Results(title = "first"), Results(title = "second"))
        else null
    }
}