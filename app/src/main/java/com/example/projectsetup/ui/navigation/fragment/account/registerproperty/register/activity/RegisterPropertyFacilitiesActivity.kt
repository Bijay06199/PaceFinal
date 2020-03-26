package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyFacilitiesBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.RegisterPropertyDetailActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyFacilitiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyFacilitiesActivity :
    BaseActivity<ActivityRegisterPropertyFacilitiesBinding, RegisterPropertyFacilitiesViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_register_property_facilities

    private val registerPropertyFacilitiesViewModel: RegisterPropertyFacilitiesViewModel by viewModel()

    override fun getViewModel(): RegisterPropertyFacilitiesViewModel =
        registerPropertyFacilitiesViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register_property_facilities)

        initView()
        setUpObservers()
    }

    private fun initView() {

        with(viewDataBinding) {
        }

    }

    private fun setUpObservers() {
        with(registerPropertyFacilitiesViewModel) {

            btnClickEvent.observe(this@RegisterPropertyFacilitiesActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyFacilitiesActivity,
                        RegisterPropertyFeatureActivity::class.java
                    )
                )
            })

            ivBackClickEvent.observe(this@RegisterPropertyFacilitiesActivity, Observer {

                startActivity(
                    Intent(
                        this@RegisterPropertyFacilitiesActivity,
                        RegisterPropertyDetailActivity::class.java
                    )
                )
            })
        }

    }
}
