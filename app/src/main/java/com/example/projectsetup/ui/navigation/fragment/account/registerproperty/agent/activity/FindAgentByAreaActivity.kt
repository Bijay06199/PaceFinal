package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityAgentBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomActivity
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAreaActivityViewModel
import kotlinx.android.synthetic.main.activity_agent.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindAgentByAreaActivity :
    BaseActivity<ActivityAgentBinding, FindAgentByAreaActivityViewModel>() {

    private val findAgentByAreaActivityViewModel: FindAgentByAreaActivityViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_agent
    override fun getViewModel(): FindAgentByAreaActivityViewModel = findAgentByAreaActivityViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_agent)

        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(findAgentByAreaActivityViewModel) {
            ivBackClicked.observe(this@FindAgentByAreaActivity, Observer {
                startActivity(
                    Intent(
                        this@FindAgentByAreaActivity,
                        RegisterPropertyRoomActivity::class.java
                    )
                )
            })

            iconNextClicked.observe(this@FindAgentByAreaActivity, Observer {
                startActivity(
                    Intent(
                        this@FindAgentByAreaActivity,
                        FindAgentByAddressActivity::class.java
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
