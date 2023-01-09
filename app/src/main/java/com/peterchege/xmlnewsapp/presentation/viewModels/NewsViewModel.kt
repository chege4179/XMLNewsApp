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
package com.peterchege.xmlnewsapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.peterchege.xmlnewsapp.data.api.responses.Article
import com.peterchege.xmlnewsapp.data.api.responses.NewsResponse
import com.peterchege.xmlnewsapp.data.respository.NewsRepositoryImpl
import com.peterchege.xmlnewsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val repository: NewsRepositoryImpl

) :ViewModel(){

    val breakingNews: MutableLiveData<Resource<List<Article>>> = MutableLiveData()

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        try {
            breakingNews.postValue(Resource.Loading())
            val response = repository.getBreakingNews(countryCode, 1)
            Log.e("Response >>>>>",response.articles.size.toString())
            breakingNews.postValue(Resource.Success(data = response.articles))
        }catch (e:HttpException){
            Log.e("HTTP exception",e.localizedMessage ?: "An error occurred http")
            breakingNews.postValue(Resource.Error(message =e.localizedMessage ?: "An error occurred http"))
        }catch (e:IOException){
            Log.e("IO Exception",e.localizedMessage ?: "An error occurred io")
            breakingNews.postValue(Resource.Error(message =e.localizedMessage ?: "An error occurred io"))
        }
    }











}