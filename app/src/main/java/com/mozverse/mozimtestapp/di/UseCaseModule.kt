package com.mozverse.mozimtestapp.di

import com.mozverse.mozim.Mozim
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import com.mozverse.mozimtestapp.domain.repository.XMLRepository
import com.mozverse.mozimtestapp.domain.usecase.AddBuiltInUrlsUseCase
import com.mozverse.mozimtestapp.domain.usecase.GetAllSessionsUseCase
import com.mozverse.mozimtestapp.domain.usecase.RemoveSessionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun providesGetAllSessionsUseCase(
        sessionRepository: SessionRepository,
    ): GetAllSessionsUseCase {
        return GetAllSessionsUseCase(
            sessionRepository = sessionRepository,
        )
    }

    @Provides
    fun providesRemoveSessionUseCase(
        sessionRepository: SessionRepository
    ): RemoveSessionUseCase {
        return RemoveSessionUseCase(
            sessionRepository = sessionRepository
        )
    }

    @Provides
    fun providesAddBuiltInUrlsUseCase(
        xmlConfigHelper: XMLConfigHelper,
        xmlRepository: XMLRepository,
        sessionRepository: SessionRepository,
        mozim: Mozim
    ): AddBuiltInUrlsUseCase {
        return AddBuiltInUrlsUseCase(
            xmlRepository = xmlRepository,
            xmlConfigHelper = xmlConfigHelper,
            sessionRepository = sessionRepository,
            mozim = mozim
        )
    }
}