package com.example.cleanarchitecture.ui.main

import android.os.Bundle
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.base.BaseActivity
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.ui.extensions.hideNavigationUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideNavigationUI()
    }
}