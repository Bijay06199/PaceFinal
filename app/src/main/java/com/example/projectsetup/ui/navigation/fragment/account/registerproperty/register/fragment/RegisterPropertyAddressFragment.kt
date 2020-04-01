package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyAddressBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyAddressViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyAddressFragment :
    BaseFragment<FragmentRegisterPropertyAddressBinding, RegisterPropertyAddressViewModel>() {

    private val registerPropertyAddressViewModel: RegisterPropertyAddressViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.fragment_register_property_address

    override fun getViewModel(): RegisterPropertyAddressViewModel = registerPropertyAddressViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()

    }

    private fun setUpObservers() {

        with(registerPropertyAddressViewModel) {

            btnClickedEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyMapFragment.start(activity!!, R.id.container_register_property)

            })

            backClickedEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyChooseFragment.start(activity!!,R.id.container_register_property)
            })



        }
    }

    private fun initView() {
        with(viewDataBinding) {

        }
    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyAddressFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }


}