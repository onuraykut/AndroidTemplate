package com.example.mvvmtemplate.ui.cars

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvvmtemplate.databinding.ActivityCarsLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityCarsLayoutBinding, LoginViewModel>() {

    override fun onActivityCreated() {

    }

    override fun observe() {
        observeCars()
    }

    override fun showHideProgress(isShow: Boolean) {
        //loading çıkart
    }

    override fun getViewBinding() = ActivityCarsLayoutBinding.inflate(layoutInflater)

    override val viewModel: LoginViewModel by viewModels()

    private fun observeCars() {
        lifecycleScope.launchWhenResumed {

        }
    }
}