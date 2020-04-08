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
import com.example.projectsetup.databinding.FragmentRegisterAgencySuccessBinding
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgencySuccessViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterAgencySuccessFragment :BaseFragment<FragmentRegisterAgencySuccessBinding,RegisterAgencySuccessViewModel>() {
    override fun getLayoutId(): Int=R.layout.fragment_register_agency_success
    private val registerAgencySuccessViewModel:RegisterAgencySuccessViewModel by viewModel()
    override fun getViewModel(): RegisterAgencySuccessViewModel =registerAgencySuccessViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerAgencySuccessViewModel){
            backClickedEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }

    }

    companion object{

        val TAG=RegisterAgencySuccessFragment::class.java.simpleName

        fun start(activity: FragmentActivity, containerId:Int){
            val fragment=RegisterAgencySuccessFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()


        }
    }

}
