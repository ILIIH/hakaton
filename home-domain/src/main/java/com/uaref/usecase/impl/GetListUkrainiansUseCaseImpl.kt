package com.uaref.usecase.impl

import com.uaref.model.Ukrainian
import com.uaref.repository.UkrainiansRepository
import com.uaref.usecase.GetListUkrainiansUseCase

internal class GetListUkrainiansUseCaseImpl(private val ukrainiansRepository: UkrainiansRepository) :
    GetListUkrainiansUseCase {
    override suspend fun execute(): List<Ukrainian> = ukrainiansRepository.getEuropeansList()
}
