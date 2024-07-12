package mende273.apollographqlclientexample.domain.datasource.remote

import mende273.apollographqlclientexample.domain.model.History
import mende273.apollographqlclientexample.domain.model.Rocket

interface RemoteDataSource {
    suspend fun getRockets(): Result<List<Rocket>>
    suspend fun getHistories(): Result<List<History>>
}