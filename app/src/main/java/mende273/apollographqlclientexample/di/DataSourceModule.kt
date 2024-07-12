package mende273.apollographqlclientexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mende273.apollographqlclientexample.domain.datasource.remote.RemoteDataSource
import mende273.apollographqlclientexample.data.datasource.remote.RemoteDataSourceImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}