package com.example.mymovies.di

import com.example.mymovies.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun nowPlayingUseCase(impl: GetNowPlayingUseCaseRemote): GetNowPlayingUseCase

    @Binds
    fun popularUseCase(impl: GetPopularUseCaseRemote): GetPopularUseCase

    @Binds
    fun topRatedUseCase(impl: GetTopRatedUseCaseRemote): GetTopRatedUseCase

    @Binds
    fun upComingUseCase(impl: GetUpComingUseCaseRemote): GetUpComingUseCase
}