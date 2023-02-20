package com.example.mymovies.di

import com.example.mymovies.data.network.repository.HomeRepository
import com.example.mymovies.data.network.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun homeRepository(impl: HomeRepositoryImpl): HomeRepository
}