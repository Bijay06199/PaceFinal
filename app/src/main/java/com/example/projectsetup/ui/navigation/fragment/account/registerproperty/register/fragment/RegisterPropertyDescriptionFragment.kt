package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyDescriptionBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyDescriptionViewModel
import com.example.projectsetup.utils.contracts.AppContracts.RegistrationType.RENT
import com.example.projectsetup.utils.contracts.AppContracts.RegistrationType.SALE
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyDescriptionFragment
    :
    BaseFragment<FragmentRegisterPropertyDescriptionBinding, RegisterPropertyDescriptionViewModel>() {
    private val registerPropertyDescriptionViewModel: RegisterPropertyDescriptionViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_register_property_description
    override fun getViewModel(): RegisterPropertyDescriptionViewModel =
        registerPropertyDescriptionViewModel

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

        with(registerPropertyDescriptionViewModel) {

            btnNextClicked.observe(viewLifecycleOwner, Observer {
                when (preferenceManager.getRegistrationType()) {
                    SALE -> {
                        RegisterPropertySalePriceFragment.start(
                            activity!!,
                            R.id.container_register_property
                        )
                    }
                    RENT -> {
                        RegisterPropertyRentPriceFragment.start(
                            activity!!,
                            R.id.container_register_property
                        )
                    }
                }

            })


            ivBackClicked.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })


        }

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyDescriptionFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}