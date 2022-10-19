package com.uaref.usecase

import com.uaref.model.European

interface GetListEuropeansUseCase {
    suspend fun execute(): List<European>
}
