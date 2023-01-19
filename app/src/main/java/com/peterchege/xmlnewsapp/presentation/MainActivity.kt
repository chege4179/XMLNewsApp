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
package com.peterchege.xmlnewsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peterchege.xmlnewsapp.R
import com.peterchege.xmlnewsapp.data.api.XMLNewsAppAPI
import com.peterchege.xmlnewsapp.data.respository.NewsRepositoryImpl
import com.peterchege.xmlnewsapp.presentation.viewModels.NewsViewModel
import com.peterchege.xmlnewsapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val newsRepository = NewsRepositoryImpl(api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(XMLNewsAppAPI::class.java))
    var viewModel: NewsViewModel = NewsViewModel(repository = newsRepository)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}