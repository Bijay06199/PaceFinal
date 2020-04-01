package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertySalePriceBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertySalePriceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertySalePriceFragment
    : BaseFragment<FragmentRegisterPropertySalePriceBinding, RegisterPropertySalePriceViewModel>() {

    private val registerPropertySalePriceViewModel: RegisterPropertySalePriceViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_property_sale_price
    override fun getViewModel(): RegisterPropertySalePriceViewModel =registerPropertySalePriceViewModel
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

        with(registerPropertySalePriceViewModel){

            btnNextClicked.observe(viewLifecycleOwner, Observer {
                RegisterPropertyPreviewFragment.start(activity!!,R.id.container_register_property)

            })

            ivBackClicked.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }

    }
    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertySalePriceFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}