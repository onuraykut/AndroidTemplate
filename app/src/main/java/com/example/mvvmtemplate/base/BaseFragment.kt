package com.example.mvvmtemplate.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mvvmtemplate.utils.OnBackPressListener
import com.example.mvvmtemplate.extensions.observeThis

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment(), OnBackPressListener {

    private val baseActivity by lazy { activity as BaseActivity<*, *>? }

    lateinit var binding: VB

    protected abstract val viewModel: VM

    abstract fun getViewBinding(): VB

    abstract fun onFragmentCreated()

    open fun observe() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = getViewBinding()
        onFragmentCreated()
        observe()
        observeLoading()
        return binding.root
    }

    override fun onResume() {
        if (activity is BaseActivity<*, *>) {
            /**
             * Activity'nin onBackPress methoduna register olunur.
             *
             */
            if (isBackEnable()) {
                (activity as BaseActivity<*, *>).onBackPressListener = this
            }
        }

        super.onResume()
    }

    override fun onPause() {
        if (activity is BaseActivity<*, *>) {
            /**
             * Activity'nin onBackPress methodundan unregister olunur.
             */
            if (isBackEnable()) {
                (activity as BaseActivity<*, *>).onBackPressListener = null
            }
        }

        super.onPause()
    }

    override fun isBackEnable() = false

    override fun onBackPressed() = true

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun observeLoading() {
        viewModel.loadingDetection.observeThis(viewLifecycleOwner) {
            baseActivity?.showHideProgress(it)
        }
    }
}