package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentFindAgentAreaBinding
import com.example.projectsetup.databinding.FragmentFindAgentByAddressBinding
import com.example.projectsetup.databinding.FragmentFindAgentByAddressBindingImpl
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAddressFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAreaFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindAgentByAddressFragment : BaseFragment<FragmentFindAgentByAddressBinding, FindAgentByAddressFragmentViewModel>() {
    private val findAgentByAddressFragmentViewModel: FindAgentByAddressFragmentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_find_agent_by_address
    override fun getViewModel(): FindAgentByAddressFragmentViewModel = findAgentByAddressFragmentViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(findAgentByAddressFragmentViewModel){

            btnFindAgentClicked.observe(viewLifecycleOwner, Observer {
                AgentListFragment.start(activity!!,R.id.container_agent)
            })

            ivBackClicked.observe(viewLifecycleOwner, Observer {
                FindAgentByAreaFragment.start(activity!!,R.id.container_agent)
            })
        }

    }

    private fun initView() {

    }

    companion object{
        val TAG="Account Fragment"
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= FindAgentByAddressFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }

    }

}