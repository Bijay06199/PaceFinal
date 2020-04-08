package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.fragment


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
import com.example.projectsetup.databinding.FragmentRegisterAgency2Binding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgency2ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterAgency2Fragment :BaseFragment<FragmentRegisterAgency2Binding,RegisterAgency2ViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_register_agency2
    private val registerAgency2ViewModel:RegisterAgency2ViewModel by viewModel()
    override fun getViewModel(): RegisterAgency2ViewModel =registerAgency2ViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun initView() {

    }

    private fun setUpObservers() {
        with(registerAgency2ViewModel){
            nextClickedEvent.observe(viewLifecycleOwner, Observer {
                RegisterAgencySuccessFragment.start(activity!!,R.id.container_agent_profile)
            })

            backClickedEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })

        }

    }

    companion object{

        val TAG=RegisterAgency2Fragment::class.java.simpleName

        fun start(activity:FragmentActivity,containerId:Int){
            val fragment=RegisterAgency2Fragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()


        }
    }
}
