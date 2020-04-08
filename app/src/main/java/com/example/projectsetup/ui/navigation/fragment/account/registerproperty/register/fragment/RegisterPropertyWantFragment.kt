package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyWantBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyWantViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyWantFragment: BaseFragment<FragmentRegisterPropertyWantBinding, RegisterPropertyWantViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_register_property_want
    private val registerPropertyWantViewModel: RegisterPropertyWantViewModel by viewModel()
    override fun getViewModel(): RegisterPropertyWantViewModel =
        registerPropertyWantViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()

    }

    private fun initView() {

    }

    private fun setUpObservers() {

        with(registerPropertyWantViewModel){
            btnNextClick.observe(viewLifecycleOwner, Observer {

                RegisterPropertyMapFragment.start(activity!!,R.id.container_register_property)

            })

            ivBack.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })
        }


    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyWantFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}
