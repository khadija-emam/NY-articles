package com.khadija.nyarticles

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.khadija.nyarticles.datalayer.entities.Results
import com.khadija.nyarticles.ui.articleview.ArticleViewFragment
import com.khadija.nyarticles.ui.home.HomeFragmentDirections
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticleViewTest(){

    @Test
    fun openArticleView_detailsDisplayedOnUI(){
        val article=Results(title = "article title",abstract = "description")
        val bundle=HomeFragmentDirections.actionHomeFragmentToArticleViewFragment(article).arguments

        launchFragmentInContainer<ArticleViewFragment>(bundle,R.style.Theme_AppCompat_Light_NoActionBar)
       onView(withId(R.id.title)).check(matches(withText("article title")))
        onView(withId(R.id.description)).check(matches(withText("description")))
        Thread.sleep(3000)


    }
}