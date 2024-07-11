package mende273.apollographqlclientexample.data.usecase

import mende273.apollographqlclientexample.domain.datasource.remote.RemoteDataSource
import mende273.apollographqlclientexample.domain.usecase.GetHistoriesUseCase
import javax.inject.Inject

class GetHistoriesUseCaseImpl
@Inject constructor(
    private val remoteDataSource: RemoteDataSource
) :
    GetHistoriesUseCase {

    override suspend fun invoke() = remoteDataSource.getHistories()
}