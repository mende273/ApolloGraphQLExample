package mende273.apollographqlclientexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mende273.apollographqlclientexample.domain.usecase.GetHistoriesUseCase
import mende273.apollographqlclientexample.data.usecase.GetHistoriesUseCaseImpl
import mende273.apollographqlclientexample.domain.usecase.GetRocketsUseCase
import mende273.apollographqlclientexample.data.usecase.GetRocketsUseCaseImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetRocketsUseCase(impl: GetRocketsUseCaseImpl): GetRocketsUseCase

    @Binds
    abstract fun bindGetHistoriesUseCase(impl: GetHistoriesUseCaseImpl): GetHistoriesUseCase
}