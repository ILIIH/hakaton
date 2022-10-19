package com.uaref.repository

import com.uaref.model.European

interface EuropeansRepository {
    suspend fun getEuropeansList(): List<European>
}
