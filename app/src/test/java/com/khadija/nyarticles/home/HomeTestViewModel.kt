package com.khadija.nyarticles.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.getOrWaitValue
import com.khadija.nyarticles.CoroutineTestRule
import com.khadija.nyarticles.repository.FakeRepository
import com.khadija.nyarticles.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeTestViewModel {

    private lateinit var fakeRepository: FakeRepository
    private lateinit var viewModel: HomeViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        viewModel = HomeViewModel(fakeRepository)
    }


    @Test
    fun initViewModel_retrieveArticles() {
        fakeRepository = FakeRepository()

        viewModel = HomeViewModel(fakeRepository)

        val articles = viewModel.articlesList.getOrWaitValue()

        Assert.assertThat(articles, CoreMatchers.not(emptyList()))
    }
}