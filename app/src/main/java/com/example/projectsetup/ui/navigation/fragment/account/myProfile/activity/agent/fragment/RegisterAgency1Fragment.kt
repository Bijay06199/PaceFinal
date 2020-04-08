package com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterAgency1Binding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgency1ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterAgency1Fragment :BaseFragment<FragmentRegisterAgency1Binding,RegisterAgency1ViewModel>() {
    override fun getLayoutId(): Int =R.layout.fragment_register_agency1
    private val registerAgency1ViewModel:RegisterAgency1ViewModel by viewModel()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): RegisterAgency1ViewModel =registerAgency1ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun initView() {

    }

    private fun setUpObservers() {
        with(registerAgency1ViewModel){
            nextClickedEvent.observe(viewLifecycleOwner, Observer {
                RegisterAgency2Fragment.start(activity!!,R.id.container_agent_profile)

            })

            backClickedEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }

    }

    companion object{
        val TAG=RegisterAgency1Fragment::class.java.simpleName
        fun start(activity:FragmentActivity,containerId:Int){
            val fragment=RegisterAgency1Fragment()
                activity.supportFragmentManager.beginTransaction()
                    .replace(containerId,fragment)
                    .addToBackStack(TAG)
                    .commit()

        }
    }


}
