package com.uaref.repository

import com.uaref.model.Ukrainian

interface UkrainiansRepository {
    suspend fun getEuropeansList(): List<Ukrainian>
}
