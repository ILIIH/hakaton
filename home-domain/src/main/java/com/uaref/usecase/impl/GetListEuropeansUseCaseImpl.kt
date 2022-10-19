package com.uaref.usecase.impl

import com.uaref.model.European
import com.uaref.repository.EuropeansRepository
import com.uaref.usecase.GetListEuropeansUseCase

internal class GetListEuropeansUseCaseImpl(private val europeansRepository: EuropeansRepository) :
    GetListEuropeansUseCase {
    override suspend fun execute(): List<European> = europeansRepository.getEuropeansList()
}
