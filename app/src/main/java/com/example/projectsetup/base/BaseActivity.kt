package com.example.projectsetup.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.data.prefs.PreferenceManager
import com.example.projectsetup.utils.viewUtils.ProgressDialogHelper
import com.example.projectsetup.utils.extentions.showAlert
import com.example.projectsetup.utils.extentions.showToast
import com.example.projectsetup.utils.extentions.setupUI
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

abstract class BaseActivity<DATA_BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel> :
    AppCompatActivity() {
    lateinit var viewDataBinding: DATA_BINDING
    var baseViewModel: VIEW_MODEL? = null
    private lateinit var progressDialog: Dialog
    val preferenceManager: PreferenceManager by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialogHelper.progressDialog(this)
        performDataBinding()
        initObservers()
        setupUI(viewDataBinding.root)
    }

    private fun initObservers() {
        baseViewModel?.apply {
            alertDialogEvent.observe(this@BaseActivity, Observer { alertDialogEvent ->
                alertDialogEvent?.let {
                    showAlert(it)
                }
            })
            showToastEvent.observe(this@BaseActivity, Observer { showToastEvent ->
                showToastEvent?.let {
                    this@BaseActivity.showToast(it)
                }
            })

            showLoading.observe(this@BaseActivity, Observer { showLoading ->
                if (showLoading)
                    showLoading()
                else
                    hideLoading()
            })




        }
    }


    fun hideLoading() {
        progressDialog.dismiss()
    }

    fun showLoading() {
        progressDialog.show()
    }



    fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.baseViewModel = baseViewModel ?: getViewModel()
        viewDataBinding.apply {
            setVariable(getBindingVariable(), baseViewModel)
            setLifecycleOwner(this@BaseActivity)
            executePendingBindings()
        }
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    open fun getBindingVariable(): Int = BR.viewModel

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): VIEW_MODEL



}