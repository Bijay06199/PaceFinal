package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentAgentOptionsBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.MyProfileActivity
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.AgentOptionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class AgentOptionsFragment : BaseFragment<FragmentAgentOptionsBinding,AgentOptionsViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_agent_options
    private val agentOptionsViewModel:AgentOptionsViewModel by viewModel()
    override fun getViewModel(): AgentOptionsViewModel=agentOptionsViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        initView()


    }

    private fun initView() {
        with(viewDataBinding){
            newRealEstate.setOnClickListener{
                if(newRealEstate.isChecked){
                    newRealEstate.isChecked=true
                    existingRealState.isChecked=false

                    btnNext.setOnClickListener{
                        RegisterAgency1Fragment.start(activity!!,R.id.container_agent_profile)
                    }
                }
            }

            existingRealState.setOnClickListener {
                if(existingRealState.isChecked){
                    existingRealState.isChecked=true
                    newRealEstate.isChecked=false
                }
            }
        }
    }

    private fun setUpObservers() {
        with(agentOptionsViewModel){
            backClickedEvent.observe(viewLifecycleOwner, Observer {
                startActivity(Intent(this@AgentOptionsFragment.activity,MyProfileActivity::class.java))

            })

        }


    }

    companion object{

        val TAG=AgentOptionsFragment::class.java.simpleName

        fun start(activity:FragmentActivity,containerId:Int){

            val fragment=AgentOptionsFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()
        }
    }



}
