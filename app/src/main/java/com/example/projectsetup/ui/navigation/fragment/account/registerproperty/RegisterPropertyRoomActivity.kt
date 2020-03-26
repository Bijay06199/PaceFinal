package com.example.projectsetup.ui.navigation.fragment.account.registerproperty

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyRoomBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.activity.FindAgentByAreaActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.RegisterPropertyRelationshipActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyRoomActivity :
    BaseActivity<ActivityRegisterPropertyRoomBinding, RegisterPropertyRoomViewModel>() {

    private val registerPropertyRoomViewModel: RegisterPropertyRoomViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_register_property_room
    override fun getViewModel(): RegisterPropertyRoomViewModel = registerPropertyRoomViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerPropertyRoomViewModel) {
            btnAgentClick.observe(this@RegisterPropertyRoomActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyRoomActivity,
                        FindAgentByAreaActivity::class.java
                    )
                )
            })

            btnRegisterClick.observe(this@RegisterPropertyRoomActivity, Observer {
                startActivity(
                    Intent(
                        this@RegisterPropertyRoomActivity,
                        RegisterPropertyRelationshipActivity::class.java
                    )
                )
            })

            onBackClick.observe(this@RegisterPropertyRoomActivity, Observer {
                finish()
            })
        }


    }

    private fun initView() {
        with(viewDataBinding) {

        }
    }
}
