package com.example.rashedalemadtask.core.di

import com.example.rashedalemadtask.core.api.RestWebService
import com.example.rashedalemadtask.firsttask.data.local.FirstLocalDataSoruceImpl
import com.example.rashedalemadtask.firsttask.data.local.FirstLocalDataSource
import com.example.rashedalemadtask.firsttask.data.remote.FirstRemoteDataSoruceImpl
import com.example.rashedalemadtask.firsttask.data.remote.FirstRemoteDataSource
import com.example.rashedalemadtask.firsttask.data.repository.FirstRepository
import com.example.rashedalemadtask.firsttask.data.repository.FirstRepositoryImpl
import com.example.rashedalemadtask.firsttask.domain.FirstUseCase
import com.example.rashedalemadtask.firsttask.domain.FirstUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirstUseCase(firstRepository: FirstRepository):FirstUseCase{
        return  FirstUseCaseImpl(firstRepository)
    }

    @Provides
    @Singleton
    fun provideFirstReposiotry( firstRemoteDataSource: FirstRemoteDataSource,firstLocalDataSource: FirstLocalDataSource):FirstRepository{
        return FirstRepositoryImpl(firstRemoteDataSource,firstLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideFirstRemoteDataSource(restWebService: RestWebService ):FirstRemoteDataSource{
        return FirstRemoteDataSoruceImpl(restWebService)
    }

    @Provides
    @Singleton
    fun provideFirstLocalDataSource(): FirstLocalDataSource {
        return FirstLocalDataSoruceImpl()
    }
}