package com.mozverse.mozimtestapp.di

import com.mozverse.mozimtestapp.data.api.XmlApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun providesXmlApi(): XmlApi {
        return Retrofit.Builder()
            .baseUrl("https://vast.moz-im.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(XmlApi::class.java)
    }
}