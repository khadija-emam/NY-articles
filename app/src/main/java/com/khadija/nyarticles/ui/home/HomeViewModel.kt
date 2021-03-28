package com.khadija.nyarticles.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khadija.nyarticles.SingleLiveEvent
import com.khadija.nyarticles.datalayer.entities.Results
import com.khadija.nyarticles.datalayer.repository.Repository
import com.khadija.nyarticles.ui.ArticleClicks
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: Repository) :ViewModel(),ArticleClicks{

    private var _articlesList= MutableLiveData<List<Results>>()
    val articlesList: LiveData<List<Results>>
        get() = _articlesList

    private var _loading = SingleLiveEvent<Boolean>()
    val loading: SingleLiveEvent<Boolean>
        get() = _loading

    private var _message = SingleLiveEvent<String>()
    val message: SingleLiveEvent<String>
        get() = _message

    private var _navTo= SingleLiveEvent<Results>()
    val navTo: SingleLiveEvent<Results>
        get() = _navTo

    fun getArticles(){
        _loading.value=true
        viewModelScope. launch {
            try {
                _articlesList.value=  repository.getArticles()
                _loading.value=false
            }catch (e:Exception){
                _loading.value=false
                _message.value=e.message
            }
        }
    }

    override fun click(results: Results) {
        _navTo.value=results
    }


}