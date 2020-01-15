package com.illicitintelligence.dbgitaapp.network

import com.illicitintelligence.dbgitaapp.model.GitUser
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GetGitService {

    //    https://api.github.com/users/dalo-chinkhwangwa-prof
    @GET("users/{userName}")
    fun getUser(@Path("userName") userName: String): Observable<GitUser>

}