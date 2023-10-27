package com.example.mvvmtemplate.ui.celebrity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmtemplate.base.BaseActivity
import com.example.mvvmtemplate.databinding.ActivityCarsLayoutBinding
import com.example.mvvmtemplate.model.Celebrity
import com.example.mvvmtemplate.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityCarsLayoutBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()
    override fun getViewBinding() = ActivityCarsLayoutBinding.inflate(layoutInflater)

    private val adapter: CelebrityAdapter by lazy {
        CelebrityAdapter(::onClickAction)
    }

    override fun onActivityCreated() {
        viewModel.getCelebrityList()
        setAdapter()
    }

    override fun observe() {
        observeCelebrities()
    }

    override fun showHideProgress(isShow: Boolean) {

    }

    private fun observeCelebrities() {
        lifecycleScope.launchWhenResumed {
            viewModel.onCelebList.collect {
                when(it) {
                    Resource.Empty -> {}
                    Resource.Loading -> {
                        showProgressDialog()
                    }
                    is Resource.Success -> {
                        adapter.replaceData(it.data?.userType?.list)
                        dismissProgressDialog()
                    }
                    is Resource.Failure -> {
                        dismissProgressDialog()
                    }
                }
            }
        }

        lifecycleScope.launchWhenResumed {
            viewModel.redirectCelebrityDetail.collect {
                it?.let {
                    startActivity(createIntent(this@LoginActivity, it))
                }
            }
        }
    }

    private fun setAdapter() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }

    private fun onClickAction(celeb: Celebrity) {
        viewModel.redirectCelebrityDetail(celeb)
    }

    companion object {

        private const val CELEB_DETAIL = "CELEB_DETAIL"
        fun createIntent(
            context: Context,
            celeb: Celebrity
        ) = Intent(context, LoginActivity::class.java).apply {
            putExtra(CELEB_DETAIL, celeb)
        }
    }
}