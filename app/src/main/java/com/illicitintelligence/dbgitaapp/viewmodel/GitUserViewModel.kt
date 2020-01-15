package com.illicitintelligence.dbgitaapp.viewmodel

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import com.illicitintelligence.dbgitaapp.BR

import com.illicitintelligence.dbgitaapp.network.GitRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GitUserViewModel(application: Application) : AndroidViewModel(application) {

    val viewProperties = ViewProperties()
    private val gitRetrofit = GitRetrofit()
    private val compositeDisposable = CompositeDisposable()

    fun getGitUserInformation(username: String) {
        compositeDisposable.add(
            gitRetrofit.getGitUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { gitUSer ->
                    viewProperties.apply {
                        userName = gitUSer.login
                        gitUrl = gitUSer.url
                    }
                })
    }

    inner class ViewProperties : BaseObservable() {

        @get: Bindable
        var userName: String = "Default"
            set(value) {
                userName = value
//                notifyPropertyChanged(BR.userName)
            }

        @get: Bindable
        var gitUrl: String = "https://default.com"
            set(value) {
                gitUrl = value
//                notifyPropertyChanged(BR.gitUrl)
            }


    }
}