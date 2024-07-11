package mende273.apollographqlclientexample.domain.usecase

import mende273.apollographqlclientexample.domain.model.History

fun interface GetHistoriesUseCase {
    suspend operator fun invoke(): Result<List<History>>
}