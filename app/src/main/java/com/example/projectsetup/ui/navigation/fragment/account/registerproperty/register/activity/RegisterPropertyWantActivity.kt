package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyWantBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.RegisterPropertyRelationshipActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.RegisterPropertySaveActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyWantViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyWantActivity :
    BaseActivity<ActivityRegisterPropertyWantBinding, RegisterPropertyWantViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_register_property_want

    private val registerPropertyWantViewModel: RegisterPropertyWantViewModel by viewModel()

    override fun getViewModel(): RegisterPropertyWantViewModel = registerPropertyWantViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register_property_want)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerPropertyWantViewModel) {

            btnNextClick.observe(this@RegisterPropertyWantActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyWantActivity,
                        RegisterPropertySaveActivity::class.java
                    )
                )
            })

            ivBack.observe(this@RegisterPropertyWantActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyWantActivity,
                        RegisterPropertyRelationshipActivity::class.java
                    )
                )
            })
        }

    }

    private fun initView() {
        with(viewDataBinding) {
        }
    }
}
