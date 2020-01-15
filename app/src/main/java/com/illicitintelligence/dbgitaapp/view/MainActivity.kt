package com.illicitintelligence.dbgitaapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.illicitintelligence.dbgitaapp.R
import com.illicitintelligence.dbgitaapp.databinding.ActivityMainBinding
import com.illicitintelligence.dbgitaapp.viewmodel.GitUserViewModel

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: GitUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        viewModel = ViewModelProviders.of(this).get(GitUserViewModel::class.java)
        binding.viewModel = viewModel.viewProperties

        viewModel.getGitUserInformation("Dalo-Chinkhwangwa-Prof")

    }
}
