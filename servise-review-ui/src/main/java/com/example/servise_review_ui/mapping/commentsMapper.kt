package com.example.servise_review_ui.mapping

import com.example.servise_review_domain.models.comment
import com.example.servise_review_ui.R
import com.example.servise_review_ui.viewState.CommentViewState
import com.maxshop.model.RecyclerItem

class commentsMapper {
    fun toViewState(comment: comment) = CommentViewState(
        comment.username,
        comment.text,
        comment.date
    )

    fun toRecyclerItem(commentViewState: CommentViewState) = RecyclerItem(
        commentViewState,
        R.layout.coment_item,
        1
    )
}