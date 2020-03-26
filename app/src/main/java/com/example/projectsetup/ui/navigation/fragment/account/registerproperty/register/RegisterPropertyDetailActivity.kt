package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyDetailBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyDetailViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.RegisterPropertyFacilitiesActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyDetailActivity :
    BaseActivity<ActivityRegisterPropertyDetailBinding, RegisterPropertyDetailViewModel>() {


    private val registerPropertyDetailViewModel: RegisterPropertyDetailViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_register_property_detail
    override fun getViewModel(): RegisterPropertyDetailViewModel = registerPropertyDetailViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register_property_detail)
        initView()
        setUpObservers()
    }

    private fun initView() {

    }

    private fun setUpObservers() {
        with(registerPropertyDetailViewModel) {
            btnClickEvent.observe(this@RegisterPropertyDetailActivity, Observer {

                startActivity(
                    Intent(
                        this@RegisterPropertyDetailActivity,
                        RegisterPropertyFacilitiesActivity::class.java
                    )
                )
            })
        }


    }
}
