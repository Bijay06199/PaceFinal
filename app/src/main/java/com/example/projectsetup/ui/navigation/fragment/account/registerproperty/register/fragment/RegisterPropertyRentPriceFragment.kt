package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyRentPriceBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyRentPriceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyRentPriceFragment : BaseFragment<FragmentRegisterPropertyRentPriceBinding, RegisterPropertyRentPriceViewModel>() {

    private val registerPropertyRentPriceViewModel: RegisterPropertyRentPriceViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_property_rent_price
    override fun getViewModel(): RegisterPropertyRentPriceViewModel =registerPropertyRentPriceViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
    }
    private fun initView() {

    }

    private fun setUpObservers() {

        with(registerPropertyRentPriceViewModel){
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
            val fragment = RegisterPropertyRentPriceFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}