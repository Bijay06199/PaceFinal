package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityAgentListBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.AgentListViewModel
import kotlinx.android.synthetic.main.activity_agent_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgentListActivity : BaseActivity<ActivityAgentListBinding, AgentListViewModel>() {

    private val agentListViewModel: AgentListViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.activity_agent_list
    override fun getViewModel(): AgentListViewModel =
        agentListViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_agent_list)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(agentListViewModel) {

            ivBackClick.observe(this@AgentListActivity, Observer {
                startActivity(
                    Intent(
                        this@AgentListActivity,
                        FindAgentByAddressActivity::class.java
                    )
                )
                finish()
            })
        }
    }

    private fun initView() {

        with(viewDataBinding) {
        }

    }
}
