package com.mozverse.mozimtestapp.di

import com.mozverse.mozim.Mozim
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.data.xml.XMLHelper
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
    fun providesMozim(): Mozim {
        return Mozim.getInstance()
    }

    @Provides
    @Singleton
    fun providesXMLConfigHelper(): XMLConfigHelper {
        return XMLConfigHelper()
    }

    @Provides
    @Singleton
    fun providesXMLHelper(): XMLHelper {
        return XMLHelper()
    }


}
