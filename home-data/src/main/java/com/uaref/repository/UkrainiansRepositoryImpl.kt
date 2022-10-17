package com.uaref.repository

import com.uaref.factory.UkrainiansFactory
import com.uaref.model.Ukrainian

internal class UkrainiansRepositoryImpl(private val ukrainiansFactory: UkrainiansFactory) :
    UkrainiansRepository {
    override suspend fun getEuropeansList(): List<Ukrainian> {
        return ukrainiansFactory.get()
    }
}
