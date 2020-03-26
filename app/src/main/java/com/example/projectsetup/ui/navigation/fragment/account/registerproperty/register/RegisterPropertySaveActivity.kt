package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertySaveBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertySaveViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.RegisterPropertyWantActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertySaveActivity :
    BaseActivity<ActivityRegisterPropertySaveBinding, RegisterPropertySaveViewModel>() {

    private val registerPropertySaveViewModel: RegisterPropertySaveViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_register_property_save

    override fun getViewModel(): RegisterPropertySaveViewModel = registerPropertySaveViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_register_property_save)
        initView()
        setUpObservers()


    }

    private fun setUpObservers() {

        with(registerPropertySaveViewModel) {
            btnClickedEvent.observe(this@RegisterPropertySaveActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertySaveActivity,
                        RegisterPropertyMapActivity::class.java
                    )
                )
            })

            onBackClicked.observe(this@RegisterPropertySaveActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertySaveActivity,
                        RegisterPropertyWantActivity::class.java
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
