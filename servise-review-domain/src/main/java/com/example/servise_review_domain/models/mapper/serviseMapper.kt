package com.example.servise_review_domain.models.mapper

import com.example.servise_review_domain.models.serviceEuropean
import com.example.servise_review_domain.models.serviceUkrainian
import com.example.servise_review_domain.models.servise

fun serviceEuropean.asServise(): servise = servise(id, specialities, description, dates, comments)
fun serviceUkrainian.asServise(): servise = servise(id, specialities, description, dates, comments)
