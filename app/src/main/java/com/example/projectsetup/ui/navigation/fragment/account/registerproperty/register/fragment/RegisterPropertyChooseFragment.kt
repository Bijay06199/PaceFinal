package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyChooseBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyChooseViewModel
import com.example.projectsetup.utils.contracts.AppContracts.RegistrationType.RENT
import com.example.projectsetup.utils.contracts.AppContracts.RegistrationType.SALE
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyChooseFragment :
    BaseFragment<FragmentRegisterPropertyChooseBinding, RegisterPropertyChooseViewModel>() {
    private val registerPropertyChooseViewModel: RegisterPropertyChooseViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_register_property_choose
    override fun getViewModel(): RegisterPropertyChooseViewModel = registerPropertyChooseViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    private fun setUpObservers() {
        with(registerPropertyChooseViewModel) {

            btnNextCLickedEvent.observe(viewLifecycleOwner, Observer {
                when(preferenceManager.getRegistrationType()){
                    SALE->RegisterPropertyAddressFragment.start(activity!!,R.id.container_register_property)
                    RENT->RegisterPropertyWantFragment.start(activity!!,R.id.container_register_property)
                }
            })

            ivBackClickedEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyChooseFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        initView()

    }

    private fun initView() {
        with(viewDataBinding) {
            forRent.setOnClickListener {
                if (forRent.isChecked) {
                    forSale.isChecked = false
                }
                preferenceManager.setRegistrationType(RENT)
            }

            forSale.setOnClickListener {
                preferenceManager.setRegistrationType(SALE)

                if (forSale.isChecked) {
                    forRent.isChecked = false
                }
            }

        }


    }
}




