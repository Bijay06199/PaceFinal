package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityFindAgentBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAddressActivityViewModel
import kotlinx.android.synthetic.main.activity_find_agent.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("NAME_SHADOWING")
class FindAgentByAddressActivity :
    BaseActivity<ActivityFindAgentBinding, FindAgentByAddressActivityViewModel>() {
    private val findAgentByAddressActivityViewModel: FindAgentByAddressActivityViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_find_agent
    override fun getViewModel(): FindAgentByAddressActivityViewModel =findAgentByAddressActivityViewModel


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(findAgentByAddressActivityViewModel){
            btnFindAgentClicked.observe(this@FindAgentByAddressActivity, Observer {
                startActivity(Intent(this@FindAgentByAddressActivity,AgentListActivity::class.java))
            })

            ivBackClicked.observe(this@FindAgentByAddressActivity, Observer {
                startActivity(Intent(this@FindAgentByAddressActivity,FindAgentByAreaActivity::class.java))
            })
        }

    }

    private fun initView() {

        with(viewDataBinding) {

        }

    }
}
