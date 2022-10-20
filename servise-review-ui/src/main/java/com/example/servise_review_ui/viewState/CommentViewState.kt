package com.example.servise_review_ui.viewState

import com.example.servise_review_domain.models.comment
import com.uaref.adapter.comparator.RecyclerItemComparator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import java.util.*

class CommentViewState(
    val username: String,
    val text: String,
    val date: Date
) : RecyclerItemComparator {
    sealed class Event {
        data class OnClick(val id: Int) : Event()
    }

    private val uiEvent = Channel<Event>(Channel.CONFLATED)
    val uiEventStream = uiEvent.receiveAsFlow()

    fun onClick(id: Int) {
        uiEvent.trySend(Event.OnClick(id)).toString()
    }

    override fun isSameItem(other: Any): Boolean {
        if (this === other) return true
        if (javaClass != other.javaClass) return false
        return (username == (other as comment).username) && (date == (other as comment).date)
    }

    override fun isSameContent(other: Any): Boolean {
        other as comment
        return (
            username == other.username &&
                text == other.text &&
                date == (other as comment).date
            )
    }
}
