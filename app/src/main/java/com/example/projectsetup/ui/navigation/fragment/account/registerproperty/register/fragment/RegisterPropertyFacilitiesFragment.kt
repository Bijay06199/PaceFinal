package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyFacilitiesBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyFacilitiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyFacilitiesFragment :
    BaseFragment<FragmentRegisterPropertyFacilitiesBinding, RegisterPropertyFacilitiesViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_register_property_facilities

    private val registerPropertyFacilitiesViewModel: RegisterPropertyFacilitiesViewModel by viewModel()

    override fun getViewModel(): RegisterPropertyFacilitiesViewModel =
        registerPropertyFacilitiesViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }

    private fun initView() {

        with(viewDataBinding) {
        }

    }

    private fun setUpObservers() {
        with(registerPropertyFacilitiesViewModel) {

            btnClickEvent.observe(viewLifecycleOwner, Observer {
            RegisterPropertyFeatureFragment.start(activity!!,R.id.container_register_property)

            })

            ivBackClickEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyDetailFragment.start(activity!!,R.id.container_register_property)

            })
        }

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyFacilitiesFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}