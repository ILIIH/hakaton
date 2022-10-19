package com.uaref.viewState

import com.uaref.adapter.comparator.RecyclerItemComparator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

internal class UkrainianViewState(
    val id: Int,
    val imageURL: String,
    val name: String,
    val description: String
) : RecyclerItemComparator {
    sealed class Event {
        data class OnClick(val id: Int) : Event()
    }

    private val uiEvent = Channel<Event>(Channel.CONFLATED)
    val uiEventStream = uiEvent.receiveAsFlow()

    fun onClick(id: Int) {
        uiEvent.trySend(Event.OnClick(id))
    }

    override fun isSameItem(other: Any): Boolean {
        if (this === other) return true
        if (javaClass != other.javaClass) return false
        return id == (other as UkrainianViewState).id
    }

    override fun isSameContent(other: Any): Boolean {
        other as EuropeanViewState
        return (
            imageURL == other.imageURL &&
                name == other.name &&
                description == other.description
            )
    }
}
