package mende273.apollographqlclientexample.data.usecase

import mende273.apollographqlclientexample.domain.datasource.remote.RemoteDataSource
import mende273.apollographqlclientexample.domain.usecase.GetRocketsUseCase
import javax.inject.Inject

class GetRocketsUseCaseImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource
) :
    GetRocketsUseCase {
    override suspend fun invoke() = remoteDataSource.getRockets()
}