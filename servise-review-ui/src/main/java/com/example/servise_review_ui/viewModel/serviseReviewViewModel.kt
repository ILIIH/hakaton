package com.example.servise_review_ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.servise
import com.example.servise_review_domain.usecase.getComments
import com.example.servise_review_domain.usecase.getServise
import kotlinx.coroutines.launch

class serviseReviewViewModel(private val getComments: getComments, private val getServise: getServise) : ViewModel() {

    private val comments = MutableLiveData<List<comment>> ()
    val _comments: LiveData<List<comment>>
        get() = comments

    private val serviseInfo = MutableLiveData<servise> ()
    val _serviseInfo: LiveData<servise>
        get() = serviseInfo

    fun getComments(username: String) {
        viewModelScope.launch {
            comments.postValue(getComments.execute(username))
        }
    }
    fun getServiseInfo(username: String) {
        viewModelScope.launch {
            serviseInfo.postValue(getServise.execute(username))
        }
    }
}
