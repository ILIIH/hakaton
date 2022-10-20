package com.example.servise_review_ui.viewModel

import androidx.lifecycle.*
import com.example.servise_review_domain.models.servise
import com.example.servise_review_domain.models.userInfo
import com.example.servise_review_domain.usecase.getComments
import com.example.servise_review_domain.usecase.getServiseEuropean
import com.example.servise_review_domain.usecase.getServiseUkrainian
import com.example.servise_review_domain.usecase.getUserInfo
import com.example.servise_review_ui.mapping.commentsMapper
import com.maxshop.model.RecyclerItem
import kotlinx.coroutines.launch

class ServiseReviewViewModel(
    private val getComments: getComments,
    private val getServiseUkrainian: getServiseUkrainian,
    private val getServiseEuropean: getServiseEuropean,
    private val getUserInfo: getUserInfo,
    private val commentsMapper: commentsMapper
) : ViewModel(), DefaultLifecycleObserver {

    private val comments = MutableLiveData<List<RecyclerItem>> ()
    val _comments: LiveData<List<RecyclerItem>>
        get() = comments

    private val serviseInfo = MutableLiveData<servise> ()
    val _serviseInfo: LiveData<servise>
        get() = serviseInfo

    private val userInfo = MutableLiveData<userInfo> ()
    val _userInfo: LiveData<userInfo>
        get() = userInfo

    fun takeServise(serviseId: Int, serviseType: String, serviseTime: String) {

    }

    fun getComments(id: Int, type: String) {
        viewModelScope.launch {
            getComments.execute(id, type).also { it ->
                it.map {
                    commentsMapper.toRecyclerItem(
                        commentsMapper.toViewState(it)
                    )
                }.also {
                    comments.postValue(it)
                }
            }
        }
    }

    fun getServiseInfo(id: Int, type: String) {
        viewModelScope.launch {
            if (type == "Ukrainian")serviseInfo.postValue(getServiseUkrainian.execute(id))
            else serviseInfo.postValue(getServiseEuropean.execute(id))
        }
    }

    fun getUserInfo(id: Int, type: String) {
        viewModelScope.launch {
            userInfo.postValue(getUserInfo.execute(id, type))
        }
    }
}
