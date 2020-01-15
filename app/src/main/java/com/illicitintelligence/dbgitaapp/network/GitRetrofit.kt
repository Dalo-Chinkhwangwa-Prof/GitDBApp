package com.illicitintelligence.dbgitaapp.network

import com.illicitintelligence.dbgitaapp.model.GitUser
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitRetrofit {

    private val BASE_URL = "https://api.github.com/"

    var gitService: GetGitService

    init {
        gitService = getGitService(getRetrofit())
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun getGitService(retrofit: Retrofit): GetGitService {
        return retrofit.create(GetGitService::class.java)
    }

    fun getGitUser(userName: String): Observable<GitUser> {
        return gitService.getUser(userName)
    }

}