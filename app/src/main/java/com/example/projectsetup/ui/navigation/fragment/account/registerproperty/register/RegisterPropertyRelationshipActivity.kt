package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyRelationshipBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyRelationshipViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.activity.RegisterPropertyWantActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyRelationshipActivity :
    BaseActivity<ActivityRegisterPropertyRelationshipBinding, RegisterPropertyRelationshipViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_register_property_relationship
    private val registerPropertyRelationShipViewModel: RegisterPropertyRelationshipViewModel by viewModel()
    override fun getViewModel(): RegisterPropertyRelationshipViewModel =
        registerPropertyRelationShipViewModel


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_register_property_relationship)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerPropertyRelationShipViewModel) {
            btnNextClicked.observe(this@RegisterPropertyRelationshipActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyRelationshipActivity,
                        RegisterPropertyWantActivity::class.java
                    )
                )
            })

            ivBack.observe(this@RegisterPropertyRelationshipActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyRelationshipActivity,
                        RegisterPropertyRoomActivity::class.java
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
