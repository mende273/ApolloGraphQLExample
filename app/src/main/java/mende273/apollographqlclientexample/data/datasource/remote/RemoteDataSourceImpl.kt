package mende273.apollographqlclientexample.data.datasource.remote

import com.apollographql.apollo3.ApolloClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import mende273.apollographqlclientexample.HistoriesQuery
import mende273.apollographqlclientexample.RocketsQuery
import mende273.apollographqlclientexample.data.mapper.toDomain
import mende273.apollographqlclientexample.domain.datasource.remote.RemoteDataSource
import mende273.apollographqlclientexample.domain.model.History
import mende273.apollographqlclientexample.domain.model.Rocket
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apolloClient: ApolloClient,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {

    override suspend fun getRockets(): Result<List<Rocket>> =
        withContext(ioDispatcher) {
            runCatching {
                val query = RocketsQuery()
                val result = apolloClient.query(query).execute()
                result.data?.rockets?.mapNotNull { it?.toDomain() } ?: emptyList()
            }
        }

    override suspend fun getHistories(): Result<List<History>> =
        withContext(ioDispatcher) {
            runCatching {
                val query = HistoriesQuery()
                val result = apolloClient.query(query).execute()
                result.data?.histories?.mapNotNull { it?.toDomain() } ?: emptyList()
            }
        }
}
