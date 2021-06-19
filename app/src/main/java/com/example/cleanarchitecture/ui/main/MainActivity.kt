package com.example.cleanarchitecture.ui.main

import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()
}