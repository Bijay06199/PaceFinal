package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentAgentListBinding
import com.example.projectsetup.databinding.FragmentFindAgentAreaBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.AgentListViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAreaFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgentListFragment : BaseFragment<FragmentAgentListBinding, AgentListViewModel>() {
    private val fragmentAgentListViewModel: AgentListViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_agent_list
    override fun getViewModel():  AgentListViewModel = fragmentAgentListViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(fragmentAgentListViewModel){
            ivBackClick.observe(viewLifecycleOwner, Observer {
               FindAgentByAddressFragment.start(activity!!,R.id.container_agent)
            })

            nextClickEvent.observe(viewLifecycleOwner, Observer {
                AgentProfileFragment.start(activity!!,R.id.container_agent)
            })

        }
    }

    private fun initView() {

    }

    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= AgentListFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

}

