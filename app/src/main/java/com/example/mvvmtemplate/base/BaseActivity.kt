package com.example.mvvmtemplate.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.mvvmtemplate.extensions.hideKeyboard
import com.example.mvvmtemplate.utils.OnBackPressListener


abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    lateinit var binding: VB

    abstract fun onActivityCreated()

    abstract fun observe()

    abstract fun showHideProgress(isShow: Boolean)

    abstract fun getViewBinding(): VB

    protected abstract val viewModel: VM

    var onBackPressListener: OnBackPressListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onActivityCreated()
        observe()
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    // TODO. onBackPressedDispatcher 'e cevrilecek
    override fun onBackPressed() {
        if (onBackPressListener != null && onBackPressListener!!.isBackEnable()) {
            if (onBackPressListener!!.onBackPressed()) {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        showHideProgress(false)
        super.onDestroy()
    }
}