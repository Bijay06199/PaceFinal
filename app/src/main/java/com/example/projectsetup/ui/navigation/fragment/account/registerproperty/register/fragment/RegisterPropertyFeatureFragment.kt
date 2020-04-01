package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyFeatureBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyFeatureViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyFeatureFragment
    : BaseFragment<FragmentRegisterPropertyFeatureBinding, RegisterPropertyFeatureViewModel>() {

    private val registerPropertyFeatureViewModel: RegisterPropertyFeatureViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_property_feature

    override fun getViewModel(): RegisterPropertyFeatureViewModel = registerPropertyFeatureViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {
        with(registerPropertyFeatureViewModel) {
            ivBackClickEvent.observe(viewLifecycleOwner, Observer {
             RegisterPropertyFacilitiesFragment.start(activity!!,R.id.container_register_property)

            })

            btnClickEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyConditionFragment.start(activity!!,R.id.container_register_property)
            })
        }


    }

    private fun initView() {

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyFeatureFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}