package com.uaref.viewModel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxshop.model.RecyclerItem
import com.uaref.mapper.EuropeanMapper
import com.uaref.mapper.UkrainianMapper
import com.uaref.usecase.GetListEuropeansUseCase
import com.uaref.usecase.GetListUkrainiansUseCase
import com.uaref.util.SingleLiveEvent
import com.uaref.viewState.EuropeanViewState
import com.uaref.viewState.UkrainianViewState
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val listEuropeansUseCase: GetListEuropeansUseCase,
    private val listUkrainiansUseCase: GetListUkrainiansUseCase,
    private val europeanMapper: EuropeanMapper,
    private val ukrainianMapper: UkrainianMapper
) : ViewModel(), DefaultLifecycleObserver {
    sealed class Event {
        data class OnClickEuropean(val id: Int) : Event()
        data class OnClickUkrainian(val id: Int) : Event()
    }

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> get() = _progressBar

    private val _europeansList = MutableLiveData<List<RecyclerItem>>()
    val europeansList: LiveData<List<RecyclerItem>> get() = _europeansList

    private val _ukrainiansList = MutableLiveData<List<RecyclerItem>>()
    val ukrainiansList: LiveData<List<RecyclerItem>> get() = _ukrainiansList

    private val _events = SingleLiveEvent<Event>()
    val events: LiveData<Event> get() = _events

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getListEuropeans()
        getListUkrainians()
    }

    private fun getListEuropeans() {
        viewModelScope.launch {
            _progressBar.value = true
            listEuropeansUseCase.execute().also {
                it.map {
                    europeanMapper.toRecyclerItem(
                        europeanMapper.toViewState(it).also {
                            collectEuropeanEvent(it)
                        }
                    )
                }.also {
                    _europeansList.value = it
                }
            }
            _progressBar.value = false
        }
    }

    private fun getListUkrainians() {
        viewModelScope.launch {
            _progressBar.value = true
            listUkrainiansUseCase.execute().also {
                it.map {
                    ukrainianMapper.toRecyclerItem(
                        ukrainianMapper.toViewState(it).also {
                            collectUkrainianEvent(it)
                        }
                    )
                }.also {
                    _ukrainiansList.value = it
                }
            }
            _progressBar.value = false
        }
    }

    private suspend fun collectEuropeanEvent(viewState: EuropeanViewState) {
        viewModelScope.launch {
            viewState.uiEventStream.collect {
                when (it) {
                    is EuropeanViewState.Event.OnClick -> _events.value = Event.OnClickEuropean(it.id)
                }
            }
        }
    }

    private suspend fun collectUkrainianEvent(viewState: UkrainianViewState) {
        viewModelScope.launch {
            viewState.uiEventStream.collect {
                when (it) {
                    is UkrainianViewState.Event.OnClick -> _events.value = Event.OnClickUkrainian(it.id)
                }
            }
        }
    }
}
