package com.uaref.usecase

import com.uaref.model.Ukrainian

interface
GetListUkrainiansUseCase {
    suspend fun execute(): List<Ukrainian>
}
