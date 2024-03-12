package com.mozverse.mozimtestapp.di

import com.mozverse.mozimtestapp.data.repository.SessionRepositoryImpl
import com.mozverse.mozimtestapp.data.repository.XMLRepositoryImpl
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import com.mozverse.mozimtestapp.domain.repository.XMLRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsSessionRepository(
        sessionRepositoryImpl: SessionRepositoryImpl
    ): SessionRepository


    @Binds
    @Singleton
    abstract fun bindsXMLRepositoryImpl(
        xmlRepositoryImpl: XMLRepositoryImpl
    ): XMLRepository
}