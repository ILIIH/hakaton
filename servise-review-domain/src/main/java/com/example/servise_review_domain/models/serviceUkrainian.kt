package com.example.servise_review_domain.models

import com.example.servise_review_domain.models.serviseInfo.time

data class serviceUkrainian(
    val id: Int,
    val specialities: String,
    val description: String,
    val dates: time,
    val comments: List<comment>
)
