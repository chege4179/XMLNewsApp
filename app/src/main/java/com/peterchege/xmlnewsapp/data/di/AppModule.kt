/*
 * Copyright 2023 XML News App Peter Chege
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.peterchege.xmlnewsapp.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.provider.SyncStateContract
import androidx.room.Room
import com.peterchege.xmlnewsapp.data.api.XMLNewsAppAPI
import com.peterchege.xmlnewsapp.data.respository.NewsRepositoryImpl
import com.peterchege.xmlnewsapp.domain.repository.NewsRepository
import com.peterchege.xmlnewsapp.presentation.viewModels.NewsViewModel
import com.peterchege.xmlnewsapp.util.Constants
import com.peterchege.xmlnewsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideXMLNewsAppAPI():XMLNewsAppAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(XMLNewsAppAPI::class.java)
    }
//    @Provides
//    @Singleton
//    fun provideNewsRepository():NewsRepositoryImpl{
//        return NewsRepositoryImpl(api = provideXMLNewsAppAPI())
//    }

//    @Provides
//    @Singleton
//    fun provideNewsViewModel(): NewsViewModel {
//        return NewsViewModel(repository = provideNewsRepository())
//    }

}