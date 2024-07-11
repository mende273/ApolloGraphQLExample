package mende273.apollographqlclientexample.domain.usecase

import mende273.apollographqlclientexample.domain.model.Rocket

fun interface GetRocketsUseCase {
    suspend operator fun invoke(): Result<List<Rocket>>
}