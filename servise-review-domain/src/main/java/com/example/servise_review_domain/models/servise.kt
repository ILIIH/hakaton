package com.example.servise_review_domain.models

data class servise(
    val username: String,
    val specialities: String, val description: String, val dates: time, val comments: List<comment>)
