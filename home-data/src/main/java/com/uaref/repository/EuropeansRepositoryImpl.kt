package com.uaref.repository

import com.uaref.factory.EuropeansFactory
import com.uaref.model.European

internal class EuropeansRepositoryImpl(private val europeansFactory: EuropeansFactory) :
    EuropeansRepository {
    override suspend fun getEuropeansList(): List<European> {
        return europeansFactory.get()
    }
}
