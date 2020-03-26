package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyFeatureBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyFeatureViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyFeatureActivity
    : BaseActivity<ActivityRegisterPropertyFeatureBinding, RegisterPropertyFeatureViewModel>() {

    private val registerPropertyFeatureViewModel: RegisterPropertyFeatureViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_register_property_feature

    override fun getViewModel(): RegisterPropertyFeatureViewModel = registerPropertyFeatureViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register_property_feature)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerPropertyFeatureViewModel) {
            ivBackClickEvent.observe(this@RegisterPropertyFeatureActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyFeatureActivity,
                        RegisterPropertyFacilitiesActivity::class.java
                    )
                )
            })
        }


    }

    private fun initView() {

    }
}
